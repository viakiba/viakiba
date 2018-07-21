package com.longma.chatserver.client;

import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;

import com.longma.chatserver.utils.ClientSessionReceivedUtil;
import com.longma.chatserver.utils.ScannerUtil;


public class ClientIoHandler extends IoHandlerAdapter{

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		 new Thread(new ClientSessionReceivedUtil(session, message)).start();
	}
	
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
		System.out.println("sessionOpened");
		new Thread(new ScannerUtil(session)).start();;
	}
	
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		System.out.println(session.toString()+cause.getMessage());
		session.close();
	}
	
}
