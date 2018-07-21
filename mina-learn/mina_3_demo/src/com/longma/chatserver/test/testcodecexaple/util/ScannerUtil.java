package com.longma.chatserver.test.testcodecexaple.util;

import java.util.Scanner;

import org.apache.mina.common.IoSession;

/**
 * 此处解释 参考readme中的mina_1_demo
 * @description: 
 * @author viakiba
 * @date 2017年7月7日
 */
public class ScannerUtil implements Runnable{
	
	private IoSession session ;
	
	public ScannerUtil(IoSession session) {
		super();
		this.session = session;
	}

	@Override
	public void run() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		for(;;){
			if(scanner.hasNext()){
				String in = scanner.nextLine();
				session.write("客户端请求的消息"+in);
			}
		}
	}
}	
