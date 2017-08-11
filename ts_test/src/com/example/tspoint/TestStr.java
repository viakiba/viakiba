package com.example.tspoint;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月27日
 */

public class TestStr {
	
	public static void main(String[] args) {
		String str = new String("1");
		String s = str;
		System.out.println(str.hashCode());
		str += "2";
		System.out.println(str.hashCode());
		
		System.out.println( s == str);
	}
}
