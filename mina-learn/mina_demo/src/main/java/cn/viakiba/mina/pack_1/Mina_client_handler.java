package cn.viakiba.mina.pack_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * 客户端  的  处理器
 * @author Administrator
 */

public class Mina_client_handler implements IoHandler{
	
	public void exceptionCaught(IoSession session, Throwable exception) throws Exception {
		System.out.println("exception =======>>");
	}
	
	/**
	 * 输入关闭
	 */
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
	}
	
	/**
	 * 接收消息  然后发送下一轮消息
	 */
	public void messageReceived(IoSession session, Object message) throws Exception {
		if(message != null){//接收服务端返回的消息
			System.out.println("进入接受环节");
			Date date = new Date();
			String printmsg = "";
			if(message instanceof Message){
				Message msg = (Message) message;
				int command = msg.getCommand();
				switch (command) {
					case Command.QUIT:
						session.close(true);//此时关闭 会告知服务器 然后服务器通过广播broadCast方法告知所有人
						System.exit(0);
						break;
					default:
						System.out.println("===================未知状态========");
						break;
				}
				printmsg = "服务端应答"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date)+": "+msg.getMsgContent();
			}else{
				printmsg = "服务端应答为null:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) +" "+message.toString();
			}
			System.out.println(printmsg);
		}
		
		Scanner scanner = new Scanner(System.in);
		if(scanner.hasNext()){
			String in = scanner.next();
			Message msg = new Message();
			msg.setId(session.getId());
			msg.setUser("admin");
			if(in.equalsIgnoreCase("quit")){
				msg.setMsgContent(in);
				msg.setCommand(Command.QUIT);
			}else{
				msg.setMsgContent(in);
				msg.setCommand(Command.BROADCAST);
			}
			session.write(msg);
		}
	}
	
	/**
	 * 服务器端发送消息
	 */
	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		//略
		
	}
	
	/**
	 * 服务器端会话关闭
	 */
	public void sessionClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * session 创建
	 */
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("session 创建");
		System.out.println(session.getId());
		System.out.println(session.getCurrentWriteMessage());
		System.out.println(session.getLastWriteTime());
		System.out.println("=================");
		
	}

	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 会话打开
	 */
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("session 打开");
		Message message = new Message();
		message.setId(session.getId());
		System.out.println("sessionid : "+message.getId());
		message.setUser("admin");
		message.setMsgContent("客户姓名"+message.getUser()+"已经连接");
		message.setCommand(Command.LOGIN);
		System.out.println(message.toString()+">>>>>>>>");
		session.write(message);
		System.out.println(session.getCurrentWriteMessage() == null ? "sdfa":"<<<<<");
	}

	
	
}
