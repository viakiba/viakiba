package haust.viakiba.utils;

import haust.viakiba.entity.MessageTextBean;

public class XmlExceptionDefault {
	private String ToUserName;//开发者微信号
	private String FromUserName;//发送方帐号（一个OpenID）
	private Long CreateTime;//消息创建时间 （整型）
	private String MsgType;//text
	private String Content;//	文本消息内容
	private String MsgId;//消息id，64位整型
	
	public XmlExceptionDefault(String toUserName, String fromUserName,
			Long createTime, String msgType, String content, String msgId) {
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		Content = "你发送的消息无法响应";
		MsgId = msgId;
	}
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public Long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
	@Override
	public String toString() {
		return "XmlExceptionDefault [ToUserName=" + ToUserName
				+ ", FromUserName=" + FromUserName + ", CreateTime="
				+ CreateTime + ", MsgType=" + MsgType + ", Content=" + Content
				+ ", MsgId=" + MsgId + "]";
	}
	
	
}
