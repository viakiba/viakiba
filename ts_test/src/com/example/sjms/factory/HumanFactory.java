package com.example.sjms.factory;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月27日
 */

public class HumanFactory {
	
	
	
	public static Human createHuman(Class c) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Human human = null;
		
		human = (Human) Class.forName(c.getName()).newInstance();
		
		return human;
	}
}
