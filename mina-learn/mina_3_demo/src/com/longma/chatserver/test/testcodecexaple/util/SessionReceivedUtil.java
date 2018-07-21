package com.longma.chatserver.test.testcodecexaple.util;

import org.apache.mina.common.IoSession;

/**
 * 此处解释 参考readme中的mina_1_demo
 * @description: 
 * @author viakiba
 * @date 2017年7月7日
 */
public class SessionReceivedUtil implements Runnable{

	@SuppressWarnings("unused")
	private IoSession session ;
	private Object message;
	
	public SessionReceivedUtil(IoSession session,Object message) {
		super();
		this.session = session;
		this.message = message;
	}
	
	@Override
	public void run() {
	   String mess = (String) message;
	   System.out.println("收到的消息"+mess);
	}
	
}
