package com.vk.producer;

import java.util.UUID;

import com.vk.messageprocess.Mesprocess;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月18日
 */

public class Producer implements Runnable {
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			String str = new String("UUID:"+UUID.randomUUID().toString().replaceAll("-", ""));
			System.out.println(str+"已经产生");
			Mesprocess.getInstance().put(str);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
