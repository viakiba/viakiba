package com.example.sjms.facade;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月31日
 */

public interface SendInterface {
	//写信
	public void writePaper(String content);
	
	//写地址
	public void writeAdress(String address);
	
	//放进邮筒
	public void putMailbox();
	
}
