package com.example.sjms.singlen;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月21日
 */

public class Pass {
	private static Pass pass = new Pass("sa");
	public String name;
	private Pass(String str){
		this.name =  str;
	}
	
	public static Pass getInstance(){
		return pass;
	}
	
}
