package com.longma.chatserver.test.testserializable.entity;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
	private String uid;
	private String username;
	
	public UserInfo() {
		super();
	}

	public UserInfo(String uid, String username) {
		super();
		this.uid = uid;
		this.username = username;
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

	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", username=" + username + "]";
	}
	
}
