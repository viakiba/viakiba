package com.example.sjms.adaptor;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年8月1日
 */

public class App {
	public static void main(String[] args) {
		//没有与外系统连接的时候，是这样写的
		IUserInfo youngGirl = new UserInfo();
		//从数据库中查到101个
		for(int i=0;i<1;i++){
			youngGirl.getMobileNumber();
		}
	}
}
