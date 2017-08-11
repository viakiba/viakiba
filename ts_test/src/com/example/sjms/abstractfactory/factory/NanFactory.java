package com.example.sjms.abstractfactory.factory;

import com.example.sjms.abstractfactory.entity.WorkerInterface;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月31日
 */

public class NanFactory extends AbstractFactory{

	/* (non-Javadoc)
	 * @see com.example.sjms.abstractfactory.factory.WorkFactory#createProgramer()
	 */
	@Override
	public WorkerInterface createProgramer() {
		// TODO Auto-generated method stub
		return super.createHuman(WorkFactoryEnum.programerimplnan);
	}

	/* (non-Javadoc)
	 * @see com.example.sjms.abstractfactory.factory.WorkFactory#createTeacher()
	 */
	@Override
	public WorkerInterface createTeacher() {
		// TODO Auto-generated method stub
		return super.createHuman(WorkFactoryEnum.teacherimplnan);
	}
	
}
