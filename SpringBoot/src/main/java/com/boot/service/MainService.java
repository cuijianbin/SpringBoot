package com.boot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.boot.utils.Util;

import net.sf.json.JSONObject;

@Service
public class MainService {
	
	@Autowired
	private JdbcTemplate primaryJdbcTemplate;//test库
	
	@Autowired
	private JdbcTemplate secondaryJdbcTemplate;//common库
	
	@Autowired
	private JdbcTemplate thirddaryJdbcTemplate;//zdr_data库
	
	/**
	 * 查询test库下面user表中的所有数据
	 * @return queryForList
	 */
	public List<Map<String, Object>> queryDataList() {
		String sql = "select * from user";
		List<Map<String, Object>> queryForList = primaryJdbcTemplate.queryForList(sql);
		System.out.println("查询结果为："+queryForList);
		return queryForList;
	}
	
	/**
	 * 查询common库下面user_info表中的所有数据(也可以使用上面的方法查询)
	 * @return queryForList
	 */
	public List<Map<String, Object>> queryCommonUserList() {
		String sql = "select * from user_info";
		//List<UserInfo> queryForList = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));//此方法也正确，但建议使用下面的queryForList方法
		List<Map<String, Object>> queryForList = secondaryJdbcTemplate.queryForList(sql);
		return queryForList;
	}
	
	public Object TestGroupLabelRelation(JSONArray gids, Integer sysuserId) {
		if(!Util.isEmpty(gids) && gids.size()>0){
			String sql ="SELECT * FROM real_group_relation rg WHERE rg.gid=? AND rg.sysuser_id=?";
			JSONObject jo = new JSONObject();
		}
		
		return null;
	}
}
