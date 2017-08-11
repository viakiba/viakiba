package com.example.sjms.singlen;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月21日
 */

public class App {
	
	public static void main(String[] args) {
		//懒汉式
		System.out.println(User.getInstance().username);
		System.out.println(User.getInstance().username);
		
		System.out.println(User.getInstance() == User.getInstance());
		
		//饿汉式
		System.out.println(Pass.getInstance().name);
		System.out.println(Pass.getInstance().name);
		
		System.out.println(Pass.getInstance() == Pass.getInstance());
		
	}
}
