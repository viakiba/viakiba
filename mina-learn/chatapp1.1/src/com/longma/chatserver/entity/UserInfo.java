package com.longma.chatserver.entity;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
	private String uid;
	private String username;
	private String password;
	
	public UserInfo() {
		super();
	}

	
	public UserInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserInfo(String uid, String username, String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", username=" + username + ", password=" + password + "]";
	}
	
}
