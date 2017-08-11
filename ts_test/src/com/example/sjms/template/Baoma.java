package com.example.sjms.template;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年8月2日
 */

public class Baoma extends CarModel{

	/* (non-Javadoc)
	 * @see com.example.sjms.template.CarModel#carStrat()
	 */
	@Override
	protected void carStrat() {
		System.out.println("Baoma"+"start");
		
	}

	/* (non-Javadoc)
	 * @see com.example.sjms.template.CarModel#carAlarm()
	 */
	@Override
	protected void carAlarm() {
		// TODO Auto-generated method stub
		System.out.println("Baoma"+"alarm");
	}

	/* (non-Javadoc)
	 * @see com.example.sjms.template.CarModel#carStop()
	 */
	@Override
	protected void carStop() {
		// TODO Auto-generated method stub
		System.out.println("Baoma"+"stop");
	}

}
