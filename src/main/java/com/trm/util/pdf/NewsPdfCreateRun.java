package com.trm.util.pdf;

import com.trm.util.pdf.obj.NewsPdfObj;

/**
 * 新闻PDF生成测试类
 * @author zhaosimiao 2018-5-3 11:05:41
 */
public class NewsPdfCreateRun {
	
	public static void main(String[] args) {
		PdfCreateMethod pcm = new PdfCreateMethod();
		String newsPath="D:/pdf/news.pdf";
		
		NewsPdfObj news=new NewsPdfObj();
        news.setTitle("新闻资讯标题");
        news.setPublishTime("2018-05-03");
        news.setOrigin("新华社");
        news.setPublishUnit("国防科工办");
        news.setContext("重要的一条新闻资讯内容重要的一条新闻资讯内容重要的一条新闻资讯内容重要的一条新闻资讯内容重要的一条新闻资讯内容重要的一条新闻资讯内容重要的一条新闻资讯内容重要的一条新闻资讯内容重要的一条新闻资讯内容重要的一条新闻资讯内容");
        
		String path= pcm.createPDF(newsPath,news,"news.pdf");
        System.out.println(path);
	}
}
