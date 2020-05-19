package com.doc.b;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import com.doc.fileReader.DecompilerUtils;
import com.doc.fileReader.DomReader;

/**
 * Servlet implementation class show
 */
@WebServlet("/show")
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");  
		//读取文件中的内容  
		StringBuffer fileContent;
		try {
			String url=request.getParameter("url");
			fileContent = new StringBuffer();  
			File file = new File(url);  
			if(file.exists()){  
				String suffix = file.getName().substring(file.getName().lastIndexOf(".")+1);
				suffix=suffix.toLowerCase();
				//视频文件排除
				String ext=DomReader.domReader("exclude");
				if(ext.indexOf(suffix)!=-1){
					request.setAttribute("content", fileContent);  
					request.getRequestDispatcher("/Show/form.jsp").forward(request, response);
					return;
				}
			    //Word2003  
			    if (suffix.equals("doc")) {  
			        FileInputStream fis = new FileInputStream(file);  
			        WordExtractor wordExtractor = new WordExtractor(fis);  
			        String text = wordExtractor.getText();  
			        fileContent.append(text);  
			    }  
			    //Word2007  
			    else if (suffix.equals("docx")) {  
			        OPCPackage opcPackage = POIXMLDocument.openPackage(url);  
			        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);  
			        String text = extractor.getText();  
			        fileContent.append(text);  
			    }
			    //JAVA反编译
			    else if(suffix.equals("class")){
			    	String temp=DecompilerUtils.decompile(url);
			    	fileContent.append(temp);
			    }
			    //XML文件
			    else if(suffix.equals("xml")){
			        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));  
			        String line = null;  
			        fileContent.append("<xmp>");
			        while((line=bufferReader.readLine()) !=null){  
			            fileContent.append(line+"\n");  
			        }
			        fileContent.append("</xmp>");
			        bufferReader.close();  
			    }
			    //记事本
			    else if(suffix.equals("txt")){
			        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));  
			        //每从BufferedReader对象中读取一行字符。  
			        String line = null;  
			        while((line=bufferReader.readLine()) !=null){  
			            fileContent.append(line+"\n");  
			        }
			        bufferReader.close();  
			    }
			    //其它
			    else{
			        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));  
			        //每从BufferedReader对象中读取一行字符。  
			        String line = null;  
			        while((line=bufferReader.readLine()) !=null){  
			            fileContent.append(line+"\n");  
			        }
			        bufferReader.close();  
			    }
			    //System.out.println(fileContent);
			    //输出  
			    request.setAttribute("content", fileContent);  
			    request.getRequestDispatcher("/Show/form.jsp").forward(request, response);
			}else{  
			    System.out.println("文件不存在！");  
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static StringBuffer getSB(String filePath) {
		StringBuffer sb = new StringBuffer();
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(filePath);
			br = new BufferedReader(reader);
			String data = null;
			while ((data = br.readLine()) != null) {
				sb.append(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//System.out.println(sb);
		return sb;
	}
}
