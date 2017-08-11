package com.example.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * @description:
 * @author viakiba
 * @date 2017年7月19日
 */
public class ThreadPoolExecutorTest implements Runnable{
	private int i=0;
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(index);
				}
			});
		}
	}
	
	@Test
	public void testThread1(){
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
		newFixedThreadPool.submit(new ThreadPoolExecutorTest());
//		System.out.println(submit.isCancelled()+"<<<<<<<<<<<<<<");
		newFixedThreadPool.submit(new ThreadPoolExecutorTest());
		newFixedThreadPool.submit(new ThreadPoolExecutorTest());
		newFixedThreadPool.submit(new ThreadPoolExecutorTest());
		
		newFixedThreadPool.submit(new ThreadPoolExecutorTest());
		newFixedThreadPool.submit(new ThreadPoolExecutorTest());
		newFixedThreadPool.submit(new ThreadPoolExecutorTest());
		newFixedThreadPool.submit(new ThreadPoolExecutorTest());
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("haha");
	}
}
