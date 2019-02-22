package com.boot.test;

import java.util.regex.Pattern;

public class TestPort {
	public static void main(String[] args) {
		//String regex = "^([1-9]|[1-9]\\d{1,3}|[1-6][0-5][0-5][0-3][0-5])$";
		String regex = "^[0-9]*[1-9][0-9]*$";
        
        String port = "30061";
        boolean flag = Pattern.matches(regex, port);
         
        System.out.println(flag);
	}
}
