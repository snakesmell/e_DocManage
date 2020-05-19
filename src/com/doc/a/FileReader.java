package com.doc.a;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

	/**
	 * 判断是否是范围内扩展名 	
	 * @param a1
	 * @return
	 */
	public static boolean fileExt(String a1){
//		String a1="D:\2.eclipseWorkbench\1_eclipse2018.jpg";
		int index = a1.lastIndexOf(".");
		String ext=a1.substring(index+1);
		String lower = ext.toLowerCase();
		for(int i=0;i<Common.ext.length;i++){
			if(Common.ext[i].equals(lower)){
				return true;	
			}
		}
		return false;
	}
	
	/**
	 * 读取文件内容
	 * @param path
	 * @return
	 */
	public static String fileContext(String path){
		File file = new File(path);
		StringBuilder sb=new StringBuilder();
		try {
			java.io.FileReader reader = new java.io.FileReader(file);
			BufferedReader buffer = new BufferedReader(reader);
			String str="";
			while(true){
				str=buffer.readLine();
				if(str!=null){
					sb.append(str);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
//	public static void main(String[] args) {
//		String a1="D:/ac.txt";
//		try {
//			String str = new String(readFromByteFile(a1));
//			System.out.println(str);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	/**
	 * 读取文件内容
	 * @param pathname
	 * @return
	 * @throws IOException
	 */
	public static String readFromByteFile(String pathname) throws IOException{
	    File filename = new File(pathname);
	    BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
	    ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
	    byte[] temp = new byte[1024];
	    int size = 0;
	    while((size = in.read(temp)) != -1){
	        out.write(temp, 0, size);
	    }
	    in.close();
	    byte[] content = out.toByteArray();
	    String str = new String(content);
	    return str;
	}
	//文件夹创建
	public static void makedir(String path){
		File file=new File(path);
		if(!file.exists()){//如果文件夹不存在
			file.mkdir();//创建文件夹
		}
	}
	//文件内容清除
	public static boolean delete(String path){
        File file = new File(path);
        if(!file.exists()){
            return false;
        }
        if(file.isFile()){
            return file.delete();
        }
        File[] files = file.listFiles();       
        for (File f : files) {
            if(f.isFile()){
                if(!f.delete()){
                    System.out.println(f.getAbsolutePath()+" delete error!");
                    return false;
                }
            }else{
                if(!delete(f.getAbsolutePath())){
                    return false;
                }
            }
        }
        return file.delete();      
    }
}
