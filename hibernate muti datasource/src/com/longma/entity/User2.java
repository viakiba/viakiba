package com.longma.entity;

import java.io.Serializable;

public class User2 implements Serializable{
	
	public int age;
	public String username;
	
	public User2() {
		super();
	}
	public User2(int age, String username) {
		super();
		this.age = age;
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "User [age=" + age + ", username=" + username + "]";
	}
	
}