package com.example.sjms.Strategy;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月24日
 */

public class StrategyContext {
	
	private IStrategy iStrategy;
	
	/**
	 * 构造函数
	 */
	public StrategyContext(IStrategy strategy) {
		this.iStrategy = strategy;
	}
	
	/**
	 * @description: 使出计谋
	 * @Date 2017年7月24日
	 * @author: viakiba
	 */
	public void operate(){
		this.iStrategy.operate();
	}
}
