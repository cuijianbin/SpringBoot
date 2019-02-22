package com.boot.controller;

/**
 * 　　　　　　　 ┏┓       ┏┓+ +
 * 　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 █████━█████  ┃+
 * 　　　　　　　┃　　　　　　 ┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　 ┃ + +
 * 　　　　　　　┗━━┓　　　 ┏━┛
 * ┃　　  ┃
 * 　　　　　　　　　┃　　  ┃ + + + +
 * 　　　　　　　　　┃　　　┃　Code is far away from     bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ +
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　 ┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 * 　　　　　　　　　 ┃┫┫　 ┃┫┫
 * 　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 */
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.boot.constants.UserInfoConst;
import com.boot.service.MainService;
import com.boot.vo.TestDataVo;

@CrossOrigin(origins = "*", maxAge = 3600)//解决跨域问题
@RestController//json格式
public class MainController {

	@Autowired
	private MainService mainService;
	
	@RequestMapping("/hello")
    public String hello() {
      return "Hello World!";
    }
	
	/**
	 * 查询test库下user表中所有用户
	 * @return queryDataList
	 */
	@RequestMapping(value="/queryDataList",method=RequestMethod.POST)
	public Object queryDataList(HttpServletRequest request) {
		List<Map<String, Object>> queryDataList = null;
		try {
			queryDataList = mainService.queryDataList();
			HttpSession session = request.getSession();
			session.setAttribute(UserInfoConst.SESSION_USER_INFO, queryDataList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryDataList;
	}
	
	@RequestMapping(value="/queryCommonUserList",method=RequestMethod.POST)
	public Object queryCommonUserList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object attribute = session.getAttribute("userInfo");
		System.out.println(attribute);
		List<Map<String, Object>> commonUserList = null;
		try {
			commonUserList = mainService.queryCommonUserList();
			System.out.println("查询结果为："+commonUserList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUserList;
	}
	
	/**
	 * 测试组织--标签关联表
	 * @param datavo
	 * @return
	 */
	@RequestMapping(value="/TestGroupLabelRelation", method=RequestMethod.POST)
	public Object TestGroupLabelRelation(@RequestBody TestDataVo datavo){
		JSONArray gids = datavo.getGids();
		Integer sysuserId = datavo.getSysuserId();
		mainService.TestGroupLabelRelation(gids,sysuserId);
		return null;
	}
}
