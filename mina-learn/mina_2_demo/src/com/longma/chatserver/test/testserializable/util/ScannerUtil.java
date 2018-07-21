package com.longma.chatserver.test.testserializable.util;

import java.util.Scanner;

import org.apache.mina.common.IoSession;

import com.longma.chatserver.test.testserializable.entity.Message;
import com.longma.chatserver.test.testserializable.entity.UserInfo;

public class ScannerUtil implements Runnable{
	
	private IoSession session ;
	
	public ScannerUtil(IoSession session) {
		super();
		this.session = session;
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		for(;;){
			if(scanner.hasNext()){
				
				//测试session.getAttribute()与session.setAttribute()方法
				//结果：
				//		只能在本段进行信息存取 不能再网络中传递，由本地的
				//  的mina框架进行维护信息。session.setAttachment()在
				//  mina2中已经被废弃不建议使用 . 
				System.out.println( session.getAttribute("login") != null ? ">>>>>>attribute" : ">>>>fail");
				String in = scanner.next();
				Message msg = new Message();
				if(in.equalsIgnoreCase("quit")){
					System.out.println("quit");
					msg.setMsgBody("quit");
					msg.setUserInfo(new UserInfo("2", "jack"));
				}else{
					System.out.println("wq");
					msg.setMsgBody("wq");
					msg.setUserInfo(new UserInfo("3", "tony"));
				}
				session.write(msg);
			}
		}
	}
}	
