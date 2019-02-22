package com.boot.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupController {

	public static void main(String[] args) throws Exception{
		
		CloseableHttpClient httpclient = HttpClients.createDefault(); // 创建httpclient实例
        HttpGet httpget = new HttpGet("http://www.tuicool.com/"); // 创建httpget实例
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        CloseableHttpResponse response = httpclient.execute(httpget); // 执行get请求
        HttpEntity entity=response.getEntity(); // 获取返回实体
        String content=EntityUtils.toString(entity, "utf-8");
        System.out.println("网页内容："+content);
        response.close(); // 关闭流和释放系统资源
         
        Document doc=Jsoup.parse(content); // 解析网页 得到文档对象
        
        int index = 0;
        
        //获取tag是title的所有DOM元素
        Elements elementsByTag = doc.getElementsByTag("title");
        for (Element element : elementsByTag) {
        	String title = element.text();
        	System.out.println("title标题"+index+"："+title);
        	index++;
		}
        
        //根据id=site_nav_top获取DOM元素
        /*Element elementById = doc.getElementById("site_nav_top");
        String navTop = elementById.text();
        System.out.println("口号："+navTop);*/
        
        //根据样式class名称来获取DOM元素
        /*Elements elementsByClass = doc.getElementsByClass("post_item");
        for (Element element : elementsByClass) {
        	String classname = element.text();
        	String html = element.html();
        	System.out.println("================start"+index+"==============");
        	System.out.println("html内容"+index+"："+html);
        	System.out.println("=================end"+index+"===============");
        	System.out.println("元素内容"+index+"："+classname);
        	index++;
		}*/
        /*Elements linkElements=doc.select("#post_list .post_item .post_item_body h3 a"); //通过选择器查找所有博客链接DOM
        for(Element e:linkElements){
            System.out.println("博客标题："+e.text());
            System.out.println("博客地址："+e.attr("href"));
            System.out.println("target:"+e.attr("target"));
        }
          
        Element linkElement=doc.select("#friend_link").first();
        System.out.println("纯文本："+linkElement.text());
        System.out.println("html："+linkElement.html());*/
	}
}
