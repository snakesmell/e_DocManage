package com.doc.c;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.doc.a.Common;
import com.doc.fileReader.DomReader;

public class ServerStart implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if(DomReader.domReader(Common.lucenceStart).equals(Common.start)){
			//new Thread(new LucenceThread(arg0,DomReader.domReader(Common.xmlRoot))).start();
		}
	}
}
