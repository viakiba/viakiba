package cn.viakiba.mina.pack_1;

import java.io.Serializable;

/**
 * 消息封装 并且可以 序列化
 * @author Administrator
 *
 */
public class Message implements Serializable{
	
	private static final long serialVersionUID = -2587568580316224999L;
	
	private long id;
	private String msgContent;
	private String user;
	private int command;
	
	public Message() {
	}

	public Message(long id, String msgContent, String user, int command) {
		super();
		this.id = id;
		this.msgContent = msgContent;
		this.user = user;
		this.command = command;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}
}
