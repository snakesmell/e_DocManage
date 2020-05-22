package com.doc.b;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doc.a.Common;
import com.doc.a.MineUtil;
import com.doc.c.Searcher;
import com.doc.fileReader.DomReader;

/**
 * Servlet implementation class page
 */
@WebServlet("/page")
public class page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public page() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder html=new StringBuilder();
		try {
			String path=DomReader.domReader(Common.xmlRoot);//+"/"
			path=path.replaceAll("\\\\","/");
			//System.out.println(path);
			File file = new File(path);
			List<File> list = MineUtil.listDirectory(file);
			for (File file2 : list) {
				if(file2.isDirectory()){//判断是否是文件夹	 onclick=query(\""+path+file2.getName()+"\")
//					System.out.println(file2.getName());		onclick=\"query('"+path+file2.getName()+"')\"
					html.append(" <li  onclick=\"query('"+path+file2.getName()+"');changcolor(this)\" class=\"leftA layui-nav-item\"><a  href=\"javascript:;\">"+file2.getName()+"</a></li>");
				}					  
			}
			//new Thread(new LucenceThread(path,request)).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	response.setCharacterEncoding("utf-8");  
		PrintWriter writer = response.getWriter();
		writer.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder html=new StringBuilder();
		try {
			String path=request.getParameter("url")+"/";
//			path=DomReader.domReader(Common.xmlRoot);
			//System.out.println(path);
			File file = new File(path);
			List<File> list = MineUtil.listDirectory(file);
			for (File file2 : list) {
				if(file2.isDirectory()){//判断是否是文件夹	 onclick=query(\""+path+file2.getName()+"\")
//					System.out.println(file2.getName());		onclick=\"query('"+path+file2.getName()+"')\"
					html.append(" <li onclick=\"query('"+path+file2.getName()+"');changcolor(this)\" class=\"leftA layui-nav-item\"><a href=\"javascript:;\">"+file2.getName()+"</a></li>");
				}					  
			}
			//new Thread(new LucenceThread(path,request)).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	response.setCharacterEncoding("utf-8");  
		PrintWriter writer = response.getWriter();
		writer.print(html);
	}

}
