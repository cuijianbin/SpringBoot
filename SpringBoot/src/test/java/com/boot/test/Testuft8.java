package com.boot.test;

public class Testuft8 {

	public static void main(String[] args) throws Exception {
		String name = "过分亲";
		String usernameString = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		
		System.out.println(usernameString);
	}
}
