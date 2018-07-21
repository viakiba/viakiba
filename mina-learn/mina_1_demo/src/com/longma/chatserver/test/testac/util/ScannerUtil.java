package com.longma.chatserver.test.testac.util;

import java.util.Scanner;

import org.apache.mina.common.IoSession;

import com.longma.chatserver.test.testac.entity.Message;

public class ScannerUtil implements Runnable{
	
	private IoSession session ;
	
	public ScannerUtil(IoSession session) {
		super();
		this.session = session;
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		//使用死循环，用于不断地接收console接受的键盘消息，每次循环都是阻塞的
		for(;;){
			if(scanner.hasNext()){
				String in = scanner.next();
				Message msg = new Message();
				if(in.equalsIgnoreCase("quit")){
					System.out.println("quit");
					msg.setMsgBody("quit");
				}else{
					System.out.println("wq");
					msg.setMsgBody("wq");
				}
				session.write(msg);
			}
		}
	}
}	
