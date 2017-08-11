package com.example.sjms.abstractfactory.factory;

import com.example.sjms.abstractfactory.entity.WorkerInterface;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月31日
 */

public interface WorkFactory {
	//制造黄色人类
	public WorkerInterface createProgramer();
	//制造一个白色人类
	public WorkerInterface createTeacher();
}
