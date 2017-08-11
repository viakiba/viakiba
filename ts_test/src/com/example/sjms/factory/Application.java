package com.example.sjms.factory;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月27日
 */

public class Application {
	public static void main(String[] args) throws Exception, IllegalAccessException, ClassNotFoundException {
		Human yelloHuman = HumanFactory.createHuman(YellowHuman.class);
		Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
		Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
		
		yelloHuman.say();
		whiteHuman.say();
		blackHuman.say();
	}
}
