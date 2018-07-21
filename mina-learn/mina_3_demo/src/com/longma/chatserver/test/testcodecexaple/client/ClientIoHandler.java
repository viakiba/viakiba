package com.longma.chatserver.test.testcodecexaple.client;

import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;

import com.longma.chatserver.test.testcodecexaple.util.ScannerUtil;
import com.longma.chatserver.test.testcodecexaple.util.SessionReceivedUtil;

/**
 * 此处解释 参考readme中的mina_1_demo
 * @description: 
 * @author viakiba
 * @date 2017年7月7日
 */
public class ClientIoHandler extends IoHandlerAdapter{
	private String msg = "默认消息"; 
	
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
	}

	public void sessionOpened(IoSession session) { 
	    session.write(this.msg.toString());
	    new Thread(new ScannerUtil(session)).start();
	} 

	public void messageReceived(IoSession session, Object message) { 
	   new Thread(new SessionReceivedUtil(session, message)).start();
	} 

	public void exceptionCaught(IoSession session, Throwable cause) { 
	   System.out.println("client exceptionCaught》》》");
	   session.close(); 
	} 
}
