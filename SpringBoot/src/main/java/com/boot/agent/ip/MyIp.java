package com.boot.agent.ip;

public class MyIp {
	
	private String ip;//ip地址
	private String port;//端口号
	private String ipType;//地址类型
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getIpType() {
		return ipType;
	}
	public void setIpType(String ipType) {
		this.ipType = ipType;
	}
	
	//无参构造方法
	public MyIp() {
		super();
	}
	
	//含参构造方法
	public MyIp(String ip, String port,String ipType) {
		this.ip=ip;
		this.port=port;
		this.ipType=ipType;
	}
	
	@Override
	public String toString() {
		return "MyIp [ip=" + ip + ", port=" + port + ", ipType=" + ipType + "]";
	}
}
