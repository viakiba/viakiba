package com.longma.chatserver.test.testac.util;

import org.apache.mina.common.IoSession;
import org.apache.mina.util.SessionLog;

import com.longma.chatserver.test.testac.entity.Message;

/**
 * 
 * @description: 用于展示接受的信息
 * @author viakiba
 * @date 2017年7月7日
 */
public class SessionReceivedUtil implements Runnable{

	private IoSession session ;
	private Object message;
	public SessionReceivedUtil(IoSession session,Object message) {
		super();
		this.session = session;
		this.message = message;
	}
	
	/**
	 * 主执行的方法
	 */
	@Override
	public void run() {
	   
	   System.out.println("in messageReceived!"); 
	   Message mess = (Message) message;
	   System.out.println(mess.getMsgBody());
	   
	}
	
}
