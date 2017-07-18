package com.vk;

import java.util.Timer;
import java.util.TimerTask;

import com.vk.messageprocess.Mesprocess;
import com.vk.producer.Producer;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月18日
 */

public class App {
	static{
		Timer t= new Timer();
		System.out.println("================");
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				Mesprocess.getInstance().start();
			}
		}, 10,10);
		
		t.schedule(new TimerTask() {
					
					@Override
					public void run() {
						for(int i=0; i<1000;i++){
							new Thread(new Producer()).start();
						}
					}
				}, 10,10);
	}
	public static void main(String[] args) {
		
		
	}
}
