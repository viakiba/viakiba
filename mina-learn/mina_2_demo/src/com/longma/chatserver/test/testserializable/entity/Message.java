package com.longma.chatserver.test.testserializable.entity;

import java.io.Serializable;

public class Message implements Serializable{
	
	private String msgBody;
	private UserInfo userInfo;
	
	public Message() {
		super();
	}
	public Message(String msgBody, UserInfo userInfo) {
		super();
		this.msgBody = msgBody;
		this.userInfo = userInfo;
	}
	
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	@Override
	public String toString() {
		return "Message [msgBody=" + msgBody + ", userInfo=" + userInfo + "]";
	}
}
