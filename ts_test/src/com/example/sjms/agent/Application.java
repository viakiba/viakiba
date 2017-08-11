package com.example.sjms.agent;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月25日
 */

public class Application {
	public static void main(String[] args) {
		
		//执行默认代理
		AgentPeople agentPeople = new AgentPeople();
		agentPeople.work();
		
		//执行指定的代理
		AgentPeople teacher = new AgentPeople(new Teacher());
		teacher.work();
		
	}
}
