package com.doc.b;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doc.a.Common;
import com.doc.a.MineUtil;

/**
 * Servlet implementation class begin
 */
@WebServlet("/query")
public class query extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public query() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//////////////////////////////磁盘 PANEL//////////////////////////////////////////	
		StringBuffer sb=new StringBuffer();
		File[] files = File.listRoots();
		for (File file : files) {
		String path = file.getPath();
		sb.append("<option value=\""+path+"\">"+path+"</option>");
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(sb.toString());			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url=request.getParameter("url")+"/";
		System.out.println(url);
		Map<String, List<File>> map = MineUtil.listDirectoryView(new File(url));
		List<File> dir = map.get(Common.Directory);
		List<File> file = map.get(Common.File);
		StringBuilder html=new StringBuilder();
		///////////////////////////文件夹/////////////////////////
		int a=1;
		html.append("<label>文件夹："+dir.size()+"</label>");
		html.append("<hr class='layui-bg-orange'>");
		for (File d : dir) {
			System.out.println(d.getName());
			html.append("<button type=\"button\" onclick=\"query('"+url+d.getName()+"')\" style=\"margin-top: 5px;font-size: 14px;\" class=\"layui-btn layui-btn-danger\">"+d.getName()+"</button>");
			html.append("<br>");
			a++;
			//System.out.println(html);
		}
		///////////////////////////文件夹/////////////////////////
		
		///////////////////////////文件/////////////////////////
		html.append("<label>文件："+file.size()+"</label>");
		html.append("<hr class='layui-bg-orange'>");
		for (File f : file) {
			long x=f.length();//文件大小
			String size=getKB(x);
			
			long last = f.lastModified();//最后修改时间
			Date date = new Date(last);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = formatter.format(date);
			html.append("<div>");
			html.append("<button type=\"button\" style=\"border-left:0px;border-right:0px;margin-top: 5px;font-size: 14px;font-family:'黑体';background-color:#E6E6FA;\" class=\"layui-btn layui-btn-primary\">"+f.getName()
			+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;size:"+size+"KB"
			+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;update:"+currentTime+"</button>");
			html.append("<button type=\"button\" onclick=\"queryload('"+url+f.getName()+"')\" style=\"border-right:0px;border-left:0px;margin-left:0px;margin-top: 5px;background-color:#E6E6FA;font-size: 14px;font-family:'黑体';\" class=\"layui-btn layui-btn-primary\">查看</button>");
			html.append("<button type=\"button\" onclick=\"download('"+url+f.getName()+"')\" style=\"border-left:0px;border-right:0px;margin-top: 5px;font-size: 14px;background-color:#E6E6FA;font-family:'黑体';\" class=\"layui-btn layui-btn-primary\">下载</button>");
			html.append("<button type=\"button\" onclick=\"fileDelete('"+url+f.getName()+"')\" style=\"border-left:0px;border-right:0px;margin-top: 5px;font-size: 14px;background-color:#EE2C2C;font-family:'黑体';\" class=\"layui-btn layui-btn-primary\">删除</button>");
			html.append("<br>");
			html.append("</div>");
		}
		///////////////////////////文件/////////////////////////
	    response.setCharacterEncoding("utf-8");  
		PrintWriter writer = response.getWriter();
		writer.print(html);
	}
	/**
	 * 文件大小返回
	 * @param x
	 * @return
	 */
	public String getKB(long x){
		float y=(float)x;
		//System.out.println(y/1024);
		String str = String.valueOf(Math.round(y/1024+0.4));
		char[] arry = str.toCharArray();
		String size="";
		int j=0;
		for(int i=arry.length-1;i>=0;i--){
			if(j%3==0&&j!=0){
				size=","+size;
			}
			size=arry[i]+size;
			j++;
		}
		return size;
	}
}
