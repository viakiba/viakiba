package com.example.sjms.template;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年8月2日
 */

public abstract class CarModel {
	
	protected abstract void carStrat();
	protected abstract void carAlarm();
	protected abstract void carStop();
	
	final public void run(){
		carStrat();
		carAlarm();
		carStop();
	}
}
