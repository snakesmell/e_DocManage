package com.doc.d;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url=request.getParameter("url");
		System.out.println(url);
		Map<String, List<File>> map = MineUtil.listDirectoryView(new File(url));
		List<File> dir = map.get(Common.Directory);
		List<File> file = map.get(Common.File);
		StringBuilder html=new StringBuilder();
		
		for (File d : dir) {
			html.append("<button type=\"button\" onclick=query(\""+url+"/"+d.getName()+"\") style=\"margin-top: 5px;\" class=\"layui-btn layui-btn-warm\">"+d.getName()+"</button>");
		}
		for (File f : file) {
			html.append("<button type=\"button\" onclick=download(\""+url+"/"+f.getName()+"\") style=\"margin-top: 5px;\" class=\"layui-btn layui-btn-primary\">"+f.getName()+"</button>");
		}
	    response.setCharacterEncoding("utf-8");  
		PrintWriter writer = response.getWriter();
		writer.print(html);
	}

}
