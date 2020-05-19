package com.doc.c;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import com.doc.a.Common;
import com.doc.a.MineUtil;
import com.doc.fileReader.DomReader;

public class LucenceThread implements Runnable{
	String path="";//文档根目录
	ServletContext context;
	public LucenceThread(ServletContextEvent arg,String path) {
		// TODO Auto-generated constructor stub
		this.path=path;
		this.context=arg.getServletContext();
	}
	@Override
	public void run() {
		while(true){
			try {
				Indexer.delete(DomReader.domReader(Common.xmlLucence));
				context.setAttribute(Common.application,"索引刷新中...");
				System.out.println("lucence begin ...");
				List<String> listFileName=new ArrayList<String>();
	        	List<String> listFilePath=new ArrayList<String>();
	        	MineUtil.listDirectoryAll(new File(path),listFileName,listFilePath);
//				System.out.println("listFileName:"+listFileName);
//				System.out.println("listFilePath:"+listFilePath);
				
				Object[] x1 = listFileName.toArray();
				Object[] x2 = listFilePath.toArray();
				
				String lucencep=DomReader.domReader(Common.xmlLucence);
				new Indexer().index(lucencep,x1,x2);
				new Indexer().index2(lucencep,x1,x2);
				
				Calendar cal = Calendar.getInstance();
				int hour = cal.get(Calendar.HOUR_OF_DAY);
				int minute = cal.get(Calendar.MINUTE);
				
				context.setAttribute(Common.application,"索引更新时间："+hour+":"+minute);
				Thread.sleep(Integer.parseInt(DomReader.domReader(Common.xmlLucenceSleep)));//延迟时长
				
			} catch (Exception e) {
				e.printStackTrace();
				context.setAttribute(Common.application,"索引刷新失败");
			}
		}
	}

}
