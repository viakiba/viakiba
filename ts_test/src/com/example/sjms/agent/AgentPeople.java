package com.example.sjms.agent;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月25日
 */

public class AgentPeople implements People{
	
	private People people;
	
	/**
	 * 默认代理程序员
	 */
	public AgentPeople(){
		this.people = new Programmer();
	}
	
	/**
	 * 实际代理，需要的定 查看Application
	 * @param people
	 */
	public AgentPeople(People people){
		this.people = people;
	}
	
	/**
	 * 执行实际被代理者的动作
	 */
	@Override
	public void work() {
		this.people.work();
	}
}
