package com.example.sjms.singlen;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月21日
 */

public class User {
	public  String username;
	public static User user;
	
	private User(String username){
		this.username =  username;
	}
	public static User getInstance(){
		if(user == null){
			user = new User("test");
		}
		return user;
	}
}
