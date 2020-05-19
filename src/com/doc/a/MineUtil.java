package com.doc.a;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doc.c.Indexer;

public class MineUtil {
	/*
     * 查找一级目录文件夹文件
     */
    public static List<File> listDirectory(File dir)throws IOException {
        if(!dir.exists())
            throw new IllegalArgumentException("目录："+dir+"不存在.");
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录。");
        }
        File[] files=dir.listFiles();
        List<File> list=new ArrayList<File>();
        if(files!=null&&files.length>0){
            for(File file:files){
                if(file.isDirectory()){
//                	System.out.println(file);
                	list.add(file);
                }
                else{
//                    System.out.println(file);
                }
            }
        }
        return list;
    }
    
    /**
     * 查看文件夹下的所有文件夹
     * @param dir
     * @return
     * @throws IOException
     */
    public static Map<String,List<File>> listDirectoryView(File dir)throws IOException {
        if(!dir.exists())
            throw new IllegalArgumentException("目录："+dir+"不存在.");
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录。");
        }
        File[] files=dir.listFiles();
        Map<String,List<File>> map=new HashMap<String,List<File>>();
        List<File> list1=new ArrayList<File>();
        List<File> list2=new ArrayList<File>();
        if(files!=null&&files.length>0){
            for(File file:files){
            	if(file.isDirectory()){
//                	System.out.println(file);
                	list1.add(file);
                }
                else{
                	list2.add(file);
//                    System.out.println(file);
                }
            }
        }
        map.put(Common.Directory, list1);
        map.put(Common.File, list2);
        return map;
    }	
    /**
     * 遍历所有文件
     * @param dir
     * @throws IOException
     */
    public static void listDirectoryAll(File dir,List<String> listFileName,List<String> listFilePath)throws IOException {
        if(!dir.exists())
            throw new IllegalArgumentException("目录："+dir+"不存在.");
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录。");
        }
        /*String[] filenames=dir.list();//返回的是字符串数组 直接子的名称 不包含子目录
        for(String string:filenames){
            System.out.println(dir+"\\"+string);
        }*/
        //如果要遍历子目录下的内容就需要构造File对象做递归操作，File提供了直接返回File对象的API
        File[] files=dir.listFiles();
        //for(File file:files){
            //System.out.println(file);
//        List<File> list=new ArrayList<File>();
        if(files!=null&&files.length>0){
//        	Map<String,String> map=new HashMap<String,String>();
            for(File file:files){
                if(file.isDirectory()){
//                	list.add(file);
//                	System.out.println(file);
                    //递归
                	listDirectoryAll(file,listFileName,listFilePath);
                }
                else{
                	listFileName.add(file.getName());
                	listFilePath.add(file.getAbsolutePath());
//                	map.put(Common.FILENAME, file.getName());
//                	map.put(Common.FILEPATH, file.getAbsolutePath());
//                	if(file.getName().indexOf(fileName)!=-1){
//                		
//                	}
                	System.out.println(file.getName());
                	System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
    
//    public static void main(String[] args) {
////    	String path="D://1.华高工作整理";
//    	String path="D://flyedt";
//    	try {
//    		List<String> listFileName=new ArrayList<String>();
//        	List<String> listFilePath=new ArrayList<String>();
//			listDirectoryAll(new File(path),listFileName,listFilePath);
//			System.out.println("listFileName:"+listFileName);
//			System.out.println("listFilePath:"+listFilePath);
//			
//			Object[] x1 = listFileName.toArray();
//			Object[] x2 = listFilePath.toArray();
//			new Indexer().index("D:\\lucene6",x1,x2);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
    
    
    public static void downLoad(String filePath, HttpServletRequest request, HttpServletResponse response, boolean isOnLine) throws Exception {
        File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;

        response.reset(); // 非常重要
        if (isOnLine) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            // 文件名应该编码成UTF-8
        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }
    
    
    public static HttpServletResponse download(HttpServletRequest request, String path, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String formFileName = file.getName();
            
            
            /////////////////////////////////////////////////文件下载//////////////////////////////////////////////////
            String userAgent = request.getHeader("User-Agent");  
            // 针对IE或者以IE为内核的浏览器：  
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            	formFileName = java.net.URLEncoder.encode(formFileName, "UTF-8");
            }else{
            	formFileName = new String(formFileName.getBytes("UTF-8"), "ISO-8859-1");
            }
            // 取得文件的后缀名。
            String ext = formFileName.substring(formFileName.lastIndexOf(".") + 1).toUpperCase();
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setHeader("Content-disposition",String.format("attachment; filename=\"%s\"", formFileName));
//            response.addHeader("Content-Disposition", "attachment;filename=" + formFileName);
            response.setContentType("multipart/form-data"); 
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            /////////////////////////////////////////////////文件下载//////////////////////////////////////////////////
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
//    public void download(){
//    	
//    }
    public static void ShowImg(HttpServletRequest request,String path, HttpServletResponse response){
    	FileInputStream in;
		response.setContentType("application/octet-stream;charset=UTF-8");
		try {
			//图片读取路径
			in=new FileInputStream(path);
			int i=in.available();
			byte[]data=new byte[i];
			in.read(data);
			in.close();
			//写图片
			OutputStream outputStream=new BufferedOutputStream(response.getOutputStream());
			outputStream.write(data);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
