package com.example.sjms.abstractfactory.entity;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月31日
 */

public abstract class Programer implements WorkerInterface{

	/* (non-Javadoc)
	 * @see com.example.sjms.abstractfactory.WorkerInterface#work()
	 */
	@Override
	public void work() {
		System.out.println("写代码");
	}

}
