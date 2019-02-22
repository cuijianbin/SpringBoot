package com.boot.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test02 {

	public static void main(String[] args) {
		String ss = "1473___سليمان Sulaiman Gu 古懿";
		String aa = "554___云梦泽人  550___习五一  1";
		String underline = "___";
		System.out.println(occurTimes(ss,underline));
		System.out.println(occurTimes(aa,underline));
		System.out.println(stringFilter(aa));
	}
	
	/**
	 * 【字符】在字符串中出现的次数
	 * @param string
	 * @param zifu
	 * @return 6228 4800 1884 2134 076
	 */
	public static int occurTimes(String string, String zifu) {
		int pos = -2;
		int n = 0;
		while (pos != -1) {
			if (pos == -2) {
				pos = -1;
			}
			pos = string.indexOf(zifu, pos + 1);
			if (pos != -1) {
				n++;
			}
		}
		return n;
	}
	
	/** 
	 * 判断一个字符串中是否包含【特殊字符】
	 *  @return true为包含，false为不包含
	 */
	public static boolean stringFilter(String str) {
		String regex = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
		Pattern pattern = Pattern.compile(regex );
		Matcher matcher = pattern.matcher(str);
		return matcher.find(); 
	}
	
	/*public static int cishu(String str, char zifu) {
		int num = 0;
		char[] chars = str.toCharArray();
		for(int i = 0; i < chars.length; i++)
		{
		    if(zifu == chars[i])
		    {
		       num++;
		    }
		}
		return num;
	}*/
}
