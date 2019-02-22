package com.boot.test;

import com.boot.utils.PinyinTool;

public class TestTopinyin {

	public static void main(String[] args) throws Exception {
		String name = "湪露未零_1289519_新浪微博";
		PinyinTool tool = new PinyinTool();
		String pinYin = tool.toPinYin(name);
		System.out.println(pinYin);
	}

}
