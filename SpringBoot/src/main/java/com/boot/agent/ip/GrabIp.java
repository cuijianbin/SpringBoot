package com.boot.agent.ip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.boot.utils.IPutils;
import com.boot.utils.SpiderUtil;
import com.boot.utils.Util;
import com.google.common.collect.Lists;

public class GrabIp {
	//抓取国内一些网站的代理ip
	public static void main(String[] args) throws Exception {
		List<MyIp> grabHtmlData = grabHtmlData();
		System.out.println("最后得到的结果："+grabHtmlData);
	}

	
	public static List<MyIp> grabHtmlData() throws IOException {
		List<MyIp> list = Lists.newArrayList();
		//读取properties文件方法一
		Properties prop =  PropertiesLoaderUtils.loadAllProperties("ip.properties");//从配置文件拿到url地址
		//读取properties文件方法二
		/*Properties prop = new Properties();
		FileInputStream in = new FileInputStream("src/main/resources/ip.properties");
		prop.load(in);
		in.close();*/
		
		String url1 = "";
		try {
			url1=prop.getProperty("ip.1").trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SpiderUtil sd = new SpiderUtil();
		Document spiderDocument = sd.spiderDocument(url1);
		//System.out.println("返回结果："+spiderDocument);
		Elements select = spiderDocument.select("#ip_list .odd");//获取得到#ip_list .odd下面所有的DOM元素
		//System.out.println(select);
		for (Element e : select) {
			MyIp myip = new MyIp();
			String ip = e.child(1).text();
			String port = e.child(2).text();
			String ipType = e.child(5).text();
			myip.setIp(ip);
			myip.setPort(port);
			myip.setIpType(ipType);
			System.out.println();
			list.add(myip);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static List<MyIp> getIpFromText(String url) throws Exception {
		List<MyIp> ipList=null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault(); // 创建httpclient实例
			HttpGet httpget = new HttpGet(url); // 创建httpget实例
			httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
			CloseableHttpResponse response = httpclient.execute(httpget); // 执行get请求
			HttpEntity entity=response.getEntity(); // 获取返回实体
			String content=EntityUtils.toString(entity, "utf-8");
			//System.out.println("网页内容："+content);
			response.close(); // 关闭流和释放系统资源
			Document doc=Jsoup.parse(content); // 解析网页 得到文档对象
			
			Elements select = doc.select("#ip_list .odd td");//获取到table中id=ip_list的DOM
			
			ipList = new ArrayList<MyIp>();
			MyIp myIp= new MyIp();
			for (int i = 0; i < select.size(); i++) {
				String text = select.get(i).text();
				if(!Util.isEmpty(text)){
					String strname = text.replaceAll(" ", "");//去除所有的空格
					boolean checkIp = IPutils.checkIp(strname);//判断是否为合法的ip地址
					if(checkIp){
						myIp.setIp(strname);
					}
					boolean checkPort = IPutils.checkPort(strname);//判断是否为正整数
					if(checkPort){
						myIp.setPort(strname);
					}
					if(!Util.isEmpty(strname) && "HTTP".equals(strname) || "HTTPS".equals(strname)){
						myIp.setIpType(strname);
					}
				}
			}
			ipList.add(myIp);
			System.out.println(ipList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ipList;
	}
}
