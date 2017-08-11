package com.example.sjms.abstractfactory;

import com.example.sjms.abstractfactory.entity.WorkerInterface;
import com.example.sjms.abstractfactory.factory.NanFactory;
import com.example.sjms.abstractfactory.factory.NvFactory;
import com.example.sjms.abstractfactory.factory.WorkFactory;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月28日
 */

public class App {
	public static void main(String[] args) {
		
		WorkFactory nanFactory = new NanFactory();
		WorkFactory nvFactory = new NvFactory();
		
		WorkerInterface createProgramer = nanFactory.createProgramer();
		WorkerInterface createTeacher = nanFactory.createTeacher();
		WorkerInterface createProgramer2 = nvFactory.createProgramer();
		WorkerInterface createTeacher2 = nvFactory.createTeacher();
		
		createProgramer.sex();
		createProgramer.work();
		
		createTeacher.sex();
		createTeacher.work();
		
		createProgramer2.sex();
		createProgramer2.work();
		createTeacher2.sex();
		createTeacher2.work();
	}
}
