package com.example.sjms.agent;


/** 
 * @description: 程序员
 * @author viakiba
 * @date 2017年7月25日
 */
public class Programmer implements People{
	/* (non-Javadoc)
	 * @see com.example.sjms.agent.People#work()
	 */
	@Override
	public void work() {
		System.out.println("程序员干活就是写代码！");
	}
}
