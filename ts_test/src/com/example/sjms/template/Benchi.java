package com.example.sjms.template;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年8月2日
 */

public class Benchi extends CarModel{

	/* (non-Javadoc)
	 * @see com.example.sjms.template.CarModel#carStrat()
	 */
	@Override
	protected void carStrat() {
		System.out.println("Benchi"+"start");
		
	}

	/* (non-Javadoc)
	 * @see com.example.sjms.template.CarModel#carAlarm()
	 */
	@Override
	protected void carAlarm() {
		// TODO Auto-generated method stub
		System.out.println("Benchi"+"alarm");
	}

	/* (non-Javadoc)
	 * @see com.example.sjms.template.CarModel#carStop()
	 */
	@Override
	protected void carStop() {
		// TODO Auto-generated method stub
		System.out.println("Benchi"+"stop");
	}
	
}
