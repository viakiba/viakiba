package com.longma.chatserver.test.testcodecexaple.server;

import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;
import org.apache.mina.util.SessionLog;

/**
 * 此处解释 参考readme中的mina_1_demo
 * @description: 
 * @author viakiba
 * @date 2017年7月7日
 */
public class ServerHandler extends IoHandlerAdapter{
	
	
	public void sessionOpened(IoSession session) { 
		   // set idle time to 60 seconds 
		   session.setIdleTime(IdleStatus.BOTH_IDLE, 60); 
		   session.setAttribute("times", new Integer(0)); 
		   System.out.println(session.toString());
		} 

		public void messageReceived(IoSession session, Object message) { 
		   System.out.println("messageReceived"); 
		   int times = ((Integer) (session.getAttribute("times"))).intValue(); 
		   System.out.println("tiems = " + times); 
		   // communicate 30 times,then close the session. 
		   if (times < 50) { 
		    times++; 
		    session.setAttribute("times", new Integer(times)); 
		    String msg; 
		    msg = (String) message; 
		    System.out.println("收到客户端消息："+msg.toString());
		    session.write(msg.toString()+"回显"); 
		   } else { 
		    session.close(); 
		   } 
		} 
		public void sessionIdle(IoSession session, IdleStatus status) { 
		   SessionLog.info(session, "Disconnecting the idle."); 
		   // disconnect an idle client 
		   System.out.println("会话空闲中。。。。。。");
		   //session.close(); 
		} 
		public void exceptionCaught(IoSession session, Throwable cause) { 
		   // close the connection on exceptional situation 
		   System.out.println("============");
		   System.out.println(cause.getMessage());
		   System.out.println("session"+session.toString()+"被移除");
		   session.close(); 
		} 
}
