package com.example.sjms.facade;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月31日
 */

public class SendUtil {
	
	public static void SendHelper(String content,String address){
		Send send = new Send();
		send.writePaper(content);
		send.writeAdress(address);
		send.putMailbox();
	}
}
