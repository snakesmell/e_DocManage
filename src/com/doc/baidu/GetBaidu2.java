package com.doc.baidu;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GetBaidu2 {
public static void main(String[] args) {
	 try {
		URL url = new URL("http://www.baidu.com/s?ie=utf-8&bs=23&f=8&rsv_bp=1&wd=23&rsv_sug3=1&rsv_sug4=89&rsv_sug1=1&inputT=0");
		 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 conn.setRequestMethod("GET"); 
		 conn.setDoOutput(true); 
		 InputStream inStream = conn.getInputStream();
		  
		 ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		 byte[] buffer = new byte[1024];
		 int len = 0;
		 while ((len = inStream.read(buffer)) != -1) {
		     outStream.write(buffer, 0, len);
		 }
		 byte[] data = outStream.toByteArray();
		 outStream.close();
		 inStream.close();
		 System.out.println(new String(data, "utf-8"));
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
