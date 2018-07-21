package com.longma.chatserver.test.testserializable.util;

import org.apache.mina.common.IoSession;
import org.apache.mina.util.SessionLog;

import com.longma.chatserver.test.testserializable.entity.Message;

public class SessionReceivedUtil implements Runnable{

	private IoSession session ;
	private Object message;
	public SessionReceivedUtil(IoSession session,Object message) {
		super();
		this.session = session;
		this.message = message;
	}
	
	@Override
	public void run() {
	   //展示/响应 信息
	   System.out.println("in messageReceived!"); 
	   Message rm = (Message) message; 
	   SessionLog.debug(session, rm.getMsgBody()); 
	   System.out.println("message is: " + rm.getMsgBody());
	   System.out.println("message is: " + rm.getUserInfo().getUsername());
	   if("tony".equals(rm.getUserInfo().getUsername())){
		   session.setAttribute("login", "test");
	   }
	   System.out.println("message is: " + rm.getUserInfo().toString());
	}
	
}
