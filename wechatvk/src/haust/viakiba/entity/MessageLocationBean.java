package haust.viakiba.entity;

public class MessageLocationBean {
	private String ToUserName;
	private String FromUserName;
	private Long CreateTime;
	private String MsgType;
	private String Location_X;
	private String Location_Y;
	private String Scale;
	private String Label;
	private String MsgId;
	
	
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


	public String getLocation_X() {
		return Location_X;
	}


	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}


	public String getLocation_Y() {
		return Location_Y;
	}


	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}


	public String getScale() {
		return Scale;
	}


	public void setScale(String scale) {
		Scale = scale;
	}


	public String getLabel() {
		return Label;
	}


	public void setLabel(String label) {
		Label = label;
	}


	public String getMsgId() {
		return MsgId;
	}


	public void setMsgId(String msgId) {
		MsgId = msgId;
	}


	@Override
	public String toString() {
		return "MessageLocationBean [ToUserName=" + ToUserName
				+ ", FromUserName=" + FromUserName + ", CreateTime="
				+ CreateTime + ", MsgType=" + MsgType + ", Location_X="
				+ Location_X + ", Location_Y=" + Location_Y + ", Scale="
				+ Scale + ", Label=" + Label + ", MsgId=" + MsgId + "]";
	}
	
}
