package com.longma.chatserver.test.testac.entity;

import java.io.Serializable;

/**
 * 
 * @description: 用于装填信息的载体
 * @author viakiba
 * @date 2017年7月7日
 */
public class Message implements Serializable{
	
	private String msgBody;

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	
	
}
