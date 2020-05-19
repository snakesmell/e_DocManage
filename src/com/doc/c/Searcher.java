package com.doc.c;

import java.io.StringReader;
import java.nio.file.Paths;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.doc.a.Common;
import com.doc.fileReader.DomReader;

public class Searcher {
	/**
	 * invalid
	 * @param indexDir
	 * @param q
	 * @throws Exception
	 */
	public static void search(String indexDir,String q)throws Exception{
		Directory dir = FSDirectory.open(Paths.get(indexDir));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher is = new IndexSearcher(reader);
		// Analyzer analyzer = new StandardAnalyzer(); // 标准分词器
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		QueryParser parser = new QueryParser("desc", analyzer);
		Query query = parser.parse(q);
		long start = System.currentTimeMillis();
		TopDocs hits = is.search(query, 10);
		long end = System.currentTimeMillis();
		System.out.println("匹配 "+q+" ，总共花费"+(end-start)+"毫秒"+"查询到"+hits.totalHits+"个记录");
		
//		QueryScorer scorer = new QueryScorer(query);
//		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
//		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color = 'red'>","</font></b>");
//		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
//		highlighter.setTextFragmenter(fragmenter);
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc = is.doc(scoreDoc.doc);
			System.out.println(doc.get("id"));
			System.out.println(doc.get("city"));
			System.out.println(doc.get("desc"));
			String desc = doc.get("desc");
			if(desc != null){
				TokenStream tokenStream = analyzer.tokenStream("desc", new StringReader(desc));
//				System.out.println(highlighter.getBestFragment(tokenStream, desc));
			}
		}
		reader.close();
	}
	
	/**
	 * invalid
	 * @param args
	 */
	public static void main(String[] args) {
		String indexDir = "D:\\lucene6";
		String q = "青岛";
		try {
			query(indexDir,q);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static String query(String indexDir,String q)throws Exception{
		Directory dir = FSDirectory.open(Paths.get(indexDir));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher is = new IndexSearcher(reader);
		// Analyzer analyzer = new StandardAnalyzer(); // 标准分词器
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		QueryParser parser = new QueryParser(Common.FILENAME, analyzer);
		Query query = parser.parse(q);
		long start = System.currentTimeMillis();
		TopDocs hits = is.search(query,Integer.parseInt(DomReader.domReader(Common.lucenceReturnSize)));
		long end = System.currentTimeMillis();
		System.out.println("匹配 "+q+" ，总共花费"+(end-start)+"毫秒"+"查询到"+hits.totalHits+"个记录");
		
//		QueryScorer scorer = new QueryScorer(query);
//		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
//		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color = 'red'>","</font></b>");
//		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
//		highlighter.setTextFragmenter(fragmenter);
		StringBuilder sb=new StringBuilder();
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			System.out.println(hits.scoreDocs.length);
			Document doc = is.doc(scoreDoc.doc);
			String path=doc.get(Common.FILEPATH);
			path = path.replaceAll("\\\\","/");
			sb.append("<button type=\"button\" style=\"border-left:0px;border-right:0px;margin-top: 5px;font-size: 14px;font-family:'黑体';background-color:#E6E6FA;\" class=\"layui-btn layui-btn-primary\">"+doc.get(Common.FILENAME)+"</button>");
			sb.append("<button type=\"button\" onclick=\"queryload('"+path+"')\" style=\"border-right:0px;border-left:0px;margin-left:0px;margin-top: 5px;background-color:#E6E6FA;font-size: 14px;font-family:'黑体';\" class=\"layui-btn layui-btn-primary\">查看</button>");
			sb.append("<button type=\"button\" onclick=\"download('"+path+"')\" style=\"border-left:0px;border-right:0px;margin-top: 5px;font-size: 14px;background-color:#E6E6FA;font-family:'黑体';\" class=\"layui-btn layui-btn-primary\">下载</button>");
			sb.append("<br>");
		}
		reader.close();
		return sb.toString();
	}
	
	public static String query2(String indexDir,String q)throws Exception{
		Directory dir = FSDirectory.open(Paths.get(indexDir));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher is = new IndexSearcher(reader);
		// Analyzer analyzer = new StandardAnalyzer(); // 标准分词器
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		QueryParser parser = new QueryParser(Common.FILECONTEXT2, analyzer);
		Query query = parser.parse(q);
		long start = System.currentTimeMillis();
		TopDocs hits = is.search(query,Integer.parseInt(DomReader.domReader(Common.lucenceReturnSize)));
		long end = System.currentTimeMillis();
		System.out.println("匹配 "+q+" ，总共花费"+(end-start)+"毫秒"+"查询到"+hits.totalHits+"个记录");
		
//		QueryScorer scorer = new QueryScorer(query);
//		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
//		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color = 'red'>","</font></b>");
//		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
//		highlighter.setTextFragmenter(fragmenter);
		StringBuilder sb=new StringBuilder();
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			System.out.println(hits.scoreDocs.length);
			Document doc = is.doc(scoreDoc.doc);
			String path=doc.get(Common.FILEPATH2);
			path = path.replaceAll("\\\\","/");
			sb.append("<button type=\"button\" style=\"border-left:0px;border-right:0px;margin-top: 5px;font-size: 14px;font-family:'黑体';background-color:#E6E6FA;\" class=\"layui-btn layui-btn-primary\">"+doc.get(Common.FILENAME2)+"</button>");
			sb.append("<button type=\"button\" onclick=\"queryload('"+path+"')\" style=\"border-right:0px;border-left:0px;margin-left:0px;margin-top: 5px;background-color:#E6E6FA;font-size: 14px;font-family:'黑体';\" class=\"layui-btn layui-btn-primary\">查看</button>");
			sb.append("<button type=\"button\" onclick=\"download('"+path+"')\" style=\"border-left:0px;border-right:0px;margin-top: 5px;font-size: 14px;background-color:#E6E6FA;font-family:'黑体';\" class=\"layui-btn layui-btn-primary\">下载</button>");
			sb.append("<br>");
		}
		reader.close();
		return sb.toString();
	}
}
