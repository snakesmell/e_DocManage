package com.doc.fileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
public class DomReader {
//	public static void main(String[] args) {
//		domReader(Common.xmlRoot);
//		domReader(Common.xmlLucence);
//		domReader(Common.xmlPassword);
//	}
	
	public static String domReader(String node) {
		try {
			//创建DOM4的解析器
			SAXReader saxReader = new SAXReader();
			InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("doc.xml");
			//DOM4j的dom树
			Document read = saxReader.read(resourceAsStream);
			//获取根节点
			Element rootElement = read.getRootElement();
//			System.out.println(rootElement.getStringValue());
			Iterator<org.dom4j.Element> iterator = rootElement.elementIterator();
			while (iterator.hasNext()){
			    Element children = iterator.next();
			    if(children.getName().equals(node)){
			    	return children.getStringValue();	
			    }
//            String p_id = children.attributeValue("person_id");
//            person.setId(p_id);
//            Iterator<org.dom4j.Element> next_iterator = children.elementIterator();
//            while (next_iterator.hasNext()){
//                Element next_children = next_iterator.next();
//                if ("name".equals(next_children.getName())){
//                    String name = next_children.getText();
//                    person.setName(name);
//                }else if("age".equals(next_children.getName())){
//                    String age = next_children.getText();
//                    person.setAge(age);
//                }
//            }
//            person_List.add(person);
			}
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//读取dom文件内容
	public static String readDomFile(File file) {
		try {
			//创建DOM4的解析器
			SAXReader saxReader = new SAXReader();
			InputStream resourceAsStream = new FileInputStream(file);
			//DOM4j的dom树
			Document read = saxReader.read(resourceAsStream);
			//获取根节点
			Element rootElement = read.getRootElement();
//			System.out.println(rootElement.getStringValue());
			Iterator<org.dom4j.Element> iterator = rootElement.elementIterator();
			StringBuilder sb=new StringBuilder();
			sb.append("<"+rootElement.getName()+">\n");
			while (iterator.hasNext()){
			    Element children = iterator.next();
			    sb.append("<"+children.getName()+">");
			    sb.append(children.getStringValue());
			    sb.append("</"+children.getName()+">\n");
			}
			sb.append("</"+rootElement.getName()+">");
			System.out.println(sb.toString());
			return sb.toString();
			//System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
