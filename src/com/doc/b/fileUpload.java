package com.doc.b;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.doc.a.Common;
import com.doc.a.FileReader;
import com.doc.fileReader.DomReader;

/**
 * Servlet implementation class fileUpload
 */
@WebServlet("/fileUpload")
public class fileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path=request.getParameter("url");
		String oper=request.getParameter("oper");
		try {
			if(oper.equals(Common.DirectoryCreate)){
				FileReader.makedir(path);
			}
			if(oper.equals(Common.FILEDelete)){
				FileReader.delete(path);
			}
			response.setCharacterEncoding("utf-8");  
			PrintWriter writer = response.getWriter();
			writer.print(Common.type1);//操作成功	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCharacterEncoding("utf-8");  
			PrintWriter writer = response.getWriter();
			writer.print(Common.type0);//操作失败
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tempDirectory = DomReader.domReader(Common.fileUploadTemp);    //要在最后加上斜杠:temp/，缓存文件目录
		String savePath="";
		try {
			int sizeThreshold = 1024 * 64;  //写满该大小的缓存后，存入硬盘中。
			File repositoryFile = new File(tempDirectory);
			FileItemFactory factory = new DiskFileItemFactory(sizeThreshold, repositoryFile);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");	//设置字符编码
			upload.setSizeMax(1024 * 1024 * 1024); // set every upload file'size less than 50M
			List items = upload.parseRequest(request);   //这里开始执行上传
			Iterator iter = items.iterator();
			Iterator iter2 = items.iterator();
			//Step1 获取路径参数
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();   //FileItem就是表示一个表单域。
				if(item.isFormField()){ //isFormField方法用于判断FileItem是否代表一个普通表单域(即非file表单域)
//					System.out.println("***"+item.getFieldName());	
//					System.out.println(item.getString());
					String a1=item.getString();
					savePath=new String(a1.getBytes("iso-8859-1"),"utf-8");
				}else {}
			}
			//Step2 文件保存
			while (iter2.hasNext()) {
				FileItem item = (FileItem) iter2.next();   //FileItem就是表示一个表单域。
				
				if(item.isFormField()){ //isFormField方法用于判断FileItem是否代表一个普通表单域(即非file表单域)
					System.out.println("***"+item.getFieldName());	
					String a1=item.getString();
					System.out.println(new String(a1.getBytes("iso-8859-1"),"utf-8"));
				}else {
//					String fieldName = item.getFieldName();  //获取表单域name属性的值
//					String fileName = item.getName();     //返回该文件在客户机上的文件名。e.g: e:\dianying\\video\1.wmv
//					System.out.println("*****"+fieldName);
//					System.out.println("*****"+fileName);
//					String fileName = path.substring(path.lastIndexOf("\\"));
					String name = item.getName();
					File uploadedFile = new File(savePath +"/"+ name);
					if(uploadedFile.isFile()){
						response.setCharacterEncoding("utf-8");  
						PrintWriter writer = response.getWriter();
						writer.print(Common.type2);//文件重复
					}else{
						item.write(uploadedFile);
						response.setCharacterEncoding("utf-8");  
						PrintWriter writer = response.getWriter();
						writer.print(Common.type1);//操作成功
					}
				}
			}
		} catch (Exception e) {
			response.setCharacterEncoding("utf-8");  
			PrintWriter writer = response.getWriter();
			writer.print(Common.type0);//操作失败
			e.printStackTrace();
		}

	}

}
