package com.vk.messageprocess;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;

import com.vk.consumer.Consumer;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月18日
 */

public class Mesprocess implements Runnable {
	
	//多线程信号量
	private CountDownLatch countDownLatch = new CountDownLatch(0);
	//消息队列
	private BlockingQueue<String> blockingQueue;
	//消费者处理器
	private Consumer consumer;
	//单例
	private static Mesprocess mesprocess;
	
	/**
	 * 私有化构造函数
	 */
	private Mesprocess() {
		blockingQueue = new LinkedBlockingDeque<String>();
	}
	
	/**
	 * @description: 获取Mesprocess实例
	 * @author: viakiba 
	 * @return
	 */
	public static Mesprocess getInstance(){
		if(mesprocess == null){
			mesprocess = new Mesprocess();
		}
		return mesprocess;
	}
	
	@Override
	public void run() {
		try{
			if(countDownLatch != null){
				countDownLatch.await();
			}
//			return;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			while(true){
				if(!blockingQueue.isEmpty()){
					consumer.getString( blockingQueue.take() );
				}else{
					System.out.println("队列无任务");
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			countDownLatch.countDown();
		}
	}
	
	public void put(String str) throws InterruptedException{
		blockingQueue.put(str);
	}

	
	/** 
	 * @description: 
	 * @author: viakiba 
	 */ 
	
	public void start() {
		new Thread(Mesprocess.getInstance()).start();
	}
}
