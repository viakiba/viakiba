package com.example.sjms.multiton;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月26日
 */

public class Contractor {
	public static void main(String[] args) {
		Worker instance = Worker.getInstance();
		String instanceInfo = instance.getInstanceInfo();
		System.out.println(instanceInfo);
	}
}
