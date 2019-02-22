package com.boot.vo;

import com.alibaba.fastjson.JSONArray;

public class TestDataVo {
	private JSONArray gids; 
	private Integer sysuserId; 
	private Integer vid; 
	private Integer rid;
	
	
	public JSONArray getGids() {
		return gids;
	}
	public void setGids(JSONArray gids) {
		this.gids = gids;
	}
	public Integer getSysuserId() {
		return sysuserId;
	}
	public void setSysuserId(Integer sysuserId) {
		this.sysuserId = sysuserId;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "TestDataVo [gids=" + gids + ", sysuserId=" + sysuserId + ", vid=" + vid + ", rid=" + rid + "]";
	}
	
}
