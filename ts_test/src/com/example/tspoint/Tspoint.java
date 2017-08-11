package com.example.tspoint;

import java.util.ArrayList;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月26日
 */

public class Tspoint {
	private String str;
	public void setStr(String str) {
		this.str = str;
	}
	public String getStr() {
		return str;
	}
	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		Tspoint tspoint = new Tspoint();
		tspoint.setStr("1");
		arraylist.add(tspoint);
		System.out.println(tspoint.getStr());
		tspoint.setStr("2");
		System.out.println(((Tspoint) arraylist.get(0)).getStr());
		arraylist.add(tspoint);
		System.out.println(((Tspoint) arraylist.get(0)).getStr());
		System.out.println(((Tspoint) arraylist.get(1)).getStr());
		
		System.out.println( arraylist.get(0) == arraylist.get(1));
	}
}
