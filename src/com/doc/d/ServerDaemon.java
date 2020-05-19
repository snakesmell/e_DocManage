package com.doc.d;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;

public class ServerDaemon implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		List<String> list =new ArrayList<String>();
		for(int i=0;i<100;i++){
			list.add(String.valueOf(i));
		}
		String [] a=new String[list.size()];
		list.toArray(a);
		System.out.println(a);
		for (String string : a) {
			System.out.println(string);
		}
	}
	
	
}
