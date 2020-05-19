package com.doc.d;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.doc.a.Common;

public class BuildFile implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		File file=new File("D:/lucene6");
		List<Map<String,String>> list =new ArrayList<Map<String,String>>();
		try {
//			MineUtil.listDirectoryAll(file, null, list);
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public static void main(String[] args) {
		File file=new File("D:/lucene6");
		List<Map<String,String>> list =new ArrayList<Map<String,String>>();
		try {
//			MineUtil.listDirectoryAll(file, null, list);
			
			for(int i=0;i<list.size();i++){
				Map<String, String> map = list.get(i);
				map.get(Common.FILENAME);
				map.get(Common.FILEPATH);
			}
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
