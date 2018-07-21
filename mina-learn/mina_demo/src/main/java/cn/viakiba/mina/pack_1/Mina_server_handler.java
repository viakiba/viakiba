package cn.viakiba.mina.pack_1;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.logging.MdcInjectionFilter;

public class Mina_server_handler implements IoHandler{
	
	//保存所有客户端已经连接的会话
	private final Set<IoSession> sessions = Collections.synchronizedSet(new HashSet<IoSession>());
	
	//保存已经连接的客户端 用户名字
	private final Set<String> users = Collections.synchronizedSet(new HashSet<String>());
	
	/**
	 * 把客户踢出会话
	 */
	public void kick(String name){
		synchronized (sessions) {
			for(IoSession session : sessions){
				if(name.equals(session.getAttribute("user"))){
					broadCast("踢出"+name);
					break;
				}
			}
		}
	}
	
	/**
	 * 返回已连接的客户端总数
	 */
	public int getNumberOfUsers(){
		return users.size();
	}
	
	/**
	 * 广播到所有的会话
	 */
	public void broadCast(String message){
		synchronized (sessions) {
			for(IoSession session : sessions){
				if(session.isConnected()){
					session.write(message);
				}
			}
		}
	}
	
	
	public void sessionClosed(IoSession session) throws Exception {
		String user = (String) session.getAttribute("user");
		users.remove(user);
		sessions.remove(session);
		broadCast(user+"离开");
	}

	public void messageReceived(IoSession session, Object message) throws Exception {
		Message msg = (Message)message;
		int command = msg.getCommand();
		String user = msg.getUser();
		switch (command) {
			case Command.QUIT:
				session.write(msg);
				sessionClosed(session);
				break;
				
			case Command.BROADCAST:
				Date date = new Date();
				broadCast(user + " " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) +" "+msg.getMsgContent());//发送广播
				break;
				
			case Command.LOGIN:
				//保存当前会话
				sessions.add(session);
				session.setAttribute("user", user);
		        MdcInjectionFilter.setProperty(session, "user", user);
		        users.add(user);
		        broadCast("用户:"+user+"加入了会话!");//发送广播
				break;
			default:
				break;
		}
	}

	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		System.out.println("连接异常退出   server端");
	}

	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
