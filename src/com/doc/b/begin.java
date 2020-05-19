package com.doc.b;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doc.a.Common;
import com.doc.a.MineUtil;
import com.doc.c.Indexer;
import com.doc.c.LucenceThread;
import com.doc.fileReader.DomReader;

/**
 * Servlet implementation class begin
 */
@WebServlet("/begin")
public class begin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static void main(String[] args) {
//		for(int i=0;i<=9;i++){
//			
//			String ss="CREATE TABLE MRS_VEH_SNAP_2020052"+i+" AS SELECT * FROM MRS_VEH_SNAP where 1=0;";
//			System.out.println(ss);
//		}
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public begin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/Login/index.jsp").forward(request,response);
	    response.setContentType("text/html;charset=utf-8"); 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder html=new StringBuilder();
		try {
			String pw=request.getParameter("password");
//			Properties prop2 = new Properties();
//			InputStream in2 = this.getClass().getClassLoader().getResourceAsStream("config.properties");
//			prop2.load(in2);
			String xmlpw=DomReader.domReader(Common.xmlPassword);
			if(!xmlpw.equals(pw)){//登录失败返回主页
				 request.getRequestDispatcher("/Login").forward(request,response);
				 return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/Show/c.jsp").forward(request,response);
	    response.setContentType("text/html;charset=utf-8"); 
		//doGet(request, response);
	}
}
