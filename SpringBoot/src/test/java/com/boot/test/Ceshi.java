package com.boot.test;

import java.util.ArrayList;
import java.util.List;

public class Ceshi {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		 List list1 =new ArrayList();
		 list1.add("1111");
		 list1.add("2222");
		 list1.add("3333");
	  
		 List list2 =new ArrayList();
		 list2.add("3333");
		 list2.add("4444");
		 list2.add("5555");
		 //差集
		 list1.removeAll(list2);
		 
		 //System.out.println("list1:"+list1);
		 
		 Integer a = -128;
		 Integer b = -128;
		 System.out.println(a==b);
	}

}
