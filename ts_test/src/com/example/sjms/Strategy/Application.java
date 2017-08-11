package com.example.sjms.Strategy;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月24日
 */

public class Application {
	public static void main(String[] args) {
		StrategyContext context;
		
		//使用策略1
		context = new StrategyContext(new StrategyInstance1());
		context.operate();
		
		//使用策略2
		context = new StrategyContext(new StrategyInstance2());
		context.operate();
		
		//使用策略3
		context = new StrategyContext(new StrategyInstance3());
		context.operate();
		
		/*
		* 策略模式的好处就是：体现了高内聚低耦合的特性呀
		*/
	}
}
