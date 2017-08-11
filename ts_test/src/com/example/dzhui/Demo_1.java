package com.example.dzhui;

import java.util.Random;

import org.junit.Test;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月21日
 */

public class Demo_1 {
	
	public static Boolean TEST = true;
	
	
	public static void main(String[] args) {
		System.out.println(TEST+"前");
		
		TEST = false;
		
		System.out.println(TEST+"后");
	}
	
	
	/** 
	 * @description: 
	 * @author: viakiba 
	 */
	@Test
	public void testRandom() {
		long currentTimeMillis = System.currentTimeMillis();
		
		Random random = new Random(currentTimeMillis);
		
		System.out.println(random);
		System.out.println(random.nextLong());
		
		System.out.println(random.nextInt());
	}
}
