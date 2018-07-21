package com.longma.chatserver.test.testac.client;


import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;

import com.longma.chatserver.test.testac.util.ScannerUtil;
import com.longma.chatserver.test.testac.util.SessionReceivedUtil;

/**
 * @description: 在这里继承的是IoHandlerAdapter，覆写需要的方法即可，如果继承IoHandler需要覆写所有接口
 * @author viakiba
 * @date 2017年7月7日
 */
public class ClientIoHandler extends IoHandlerAdapter{
	private Object msg; 
	
	public ClientIoHandler(Object msg) { 
		   this.msg = msg; 
		} 
	
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
		//会话创建
		System.out.println("session create");
		//在创建的同时，创建一个异步现成，用于接收键盘输入的信息，发送到服务器上  放入session对象是需要通过session write方法发送信息
		new Thread(new ScannerUtil(session)).start();
	}

	//在创建会话操作上，执行sessionCreate方法后会紧挨着执行sessionOpened方法，表明会话已经创建，长连接确立。
	public void sessionOpened(IoSession session) { 
		System.out.println("session opened");
	} 

	//主要的方法，用于接收对放发来的信息(已经经过过滤器链的处理)
	public void messageReceived(IoSession session, Object message) { 
	   //每次接收到服务端发来的消息，都会新启一个异步线程用于展示和响应
	   //message 已经经过过滤器的出来了 可以进行强砖
	   new Thread(new SessionReceivedUtil(session, message)).start();
	} 

	//如果抛出异常，则关闭此会话
	public void exceptionCaught(IoSession session, Throwable cause) { 
	   System.out.println("session 异常");
	   session.close(); 
	} 
}
