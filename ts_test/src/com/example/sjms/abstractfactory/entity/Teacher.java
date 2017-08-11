package com.example.sjms.abstractfactory.entity;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月31日
 */

public abstract class Teacher implements WorkerInterface{

	/* (non-Javadoc)
	 * @see com.example.sjms.abstractfactory.WorkerInterface#work()
	 */
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("教书");
	}
}
