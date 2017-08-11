package com.example.sjms.facade;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月31日
 */

public class Send implements SendInterface{

	/* (non-Javadoc)
	 * @see com.example.sjms.facade.SendInterface#writePaper(java.lang.String)
	 */
	@Override
	public void writePaper(String content) {
		System.out.println("写信。。。"+content);
		
	}

	/* (non-Javadoc)
	 * @see com.example.sjms.facade.SendInterface#writeAdress(java.lang.String)
	 */
	@Override
	public void writeAdress(String address) {
		// TODO Auto-generated method stub
		System.out.println("写地址。。。"+address);
	}

	/* (non-Javadoc)
	 * @see com.example.sjms.facade.SendInterface#putMailbox(java.lang.String)
	 */
	@Override
	public void putMailbox() {
		// TODO Auto-generated method stub
		System.out.println("放进邮筒");
	}
	
}
