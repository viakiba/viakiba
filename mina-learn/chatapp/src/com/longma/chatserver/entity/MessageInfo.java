package com.longma.chatserver.entity;

import java.io.Serializable;

public class MessageInfo implements Serializable{
	
	private String mid;//message的id
	private String tag;//消息类型
	private String content;//正文
	private String userid;//发送人的id
	private String tuserid;//接收人的id
	
	public MessageInfo() {
		super();
	}
	
	public MessageInfo(String mid, String tag, String content, String userid, String tuserid) {
		super();
		this.mid = mid;
		this.tag = tag;
		this.content = content;
		this.userid = userid;
		this.tuserid = tuserid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTuserid() {
		return tuserid;
	}

	public void setTuserid(String tuserid) {
		this.tuserid = tuserid;
	}

	@Override
	public String toString() {
		return "MessageInfo [mid=" + mid + ", tag=" + tag + ", content=" + content + ", userid=" + userid + ", tuserd="
				+ tuserid + "]";
	}
	
}
