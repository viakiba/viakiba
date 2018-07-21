package com.longma.chatserver.test.testserializable.client;

import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;

import com.longma.chatserver.test.testserializable.util.ScannerUtil;
import com.longma.chatserver.test.testserializable.util.SessionReceivedUtil;

/**
 * 
 * @description: 继承IoHandlerAdapter实现需要的方法即可，也可以继承IoHandler实现所有方法
 * @author viakiba
 * @date 2017年7月7日
 */
public class ClientIoHandler extends IoHandlerAdapter{
	private Object msg; 
	
	public ClientIoHandler(Object msg) { 
		   this.msg = msg; 
		} 
	
	public void sessionCreated(IoSession session) throws Exception {
		super.sessionCreated(session);
	}
	

	public void sessionOpened(IoSession session) { 
		//新启一个线程用于接收console的输入信息
		new Thread(new ScannerUtil(session)).start();
		//发送初始消息
	    session.write(this.msg);
	} 

	public void messageReceived(IoSession session, Object message) { 
	   //每次接受到的信息处理 都新奇一个线程处理展示响应
	   new Thread(new SessionReceivedUtil(session, message)).start();
	   
	} 
	
	public void exceptionCaught(IoSession session, Throwable cause) { 
		//出现异常则关闭会话
		session.close(); 
	} 
}
