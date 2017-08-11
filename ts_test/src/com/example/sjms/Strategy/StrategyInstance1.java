package com.example.sjms.Strategy;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月24日
 */

public class StrategyInstance1 implements IStrategy{
	/* (non-Javadoc)
	 * @see com.example.sjms.Strategy.IStrategy#operate()
	 */
	@Override
	public void operate() {
		System.out.println("执行策略1");
	}
}
