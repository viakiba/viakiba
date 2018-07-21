package com.longma.chatserver.test.testserializable.server;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;
import org.apache.mina.util.SessionLog;

import com.longma.chatserver.test.testserializable.entity.Message;
import com.longma.chatserver.test.testserializable.entity.UserInfo;

public class ServerHandler extends IoHandlerAdapter{
	
	public static final Set<IoSession> map = new HashSet();
	
	static{
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("定时任务开启");
				for(IoSession session : map){
					System.out.println("dasdad>>>>>定时任务");
					System.out.println(session.toString());
					Message message = new Message();
					message.setMsgBody("定时任务消息");
					message.setUserInfo(new UserInfo("4", "定时任务助手"));
					session.write(message);
				}
			}
		},1000, 20000);
	}
	public void sessionOpened(IoSession session) { 
		   // set idle time to 60 seconds 
		   session.setIdleTime(IdleStatus.BOTH_IDLE, 60); 
		   session.setAttribute("times", new Integer(0)); 
		   System.out.println(session.toString());
		   map.add(session);
		} 

		public void messageReceived(IoSession session, Object message) { 
		   System.out.println("messageReceived"); 
		   int times = ((Integer) (session.getAttribute("times"))).intValue(); 
		   System.out.println("tiems = " + times); 
		   // communicate 30 times,then close the session. 
		   if (times < 50) { 
		    times++; 
		    session.setAttribute("times", new Integer(times)); 
		    Message msg; 
		    msg = (Message) message; 
		    msg.setMsgBody("in server side: " + msg.getMsgBody()); 
		    System.out.println("begin send msg: " + msg.getMsgBody()); 
		    System.out.println("begin send msg: " + msg.getUserInfo().getUsername()); 
		    msg.setMsgBody("消息已经收到"+times);
		    session.write(msg); 
		   } else { 
		    session.close(); 
		   } 
		} 
		public void sessionIdle(IoSession session, IdleStatus status) { 
		   SessionLog.info(session, "Disconnecting the idle."); 
		   // disconnect an idle client 
		   session.close(); 
		} 
		public void exceptionCaught(IoSession session, Throwable cause) { 
		   // close the connection on exceptional situation 
		   session.close(); 
		   System.out.println("session"+session.toString()+"被移除");
		   map.remove(session);
		} 
}
