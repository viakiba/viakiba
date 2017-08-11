package com.example.sjms.abstractfactory.factory;

import com.example.sjms.abstractfactory.entity.WorkerInterface;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月31日
 */

public abstract class AbstractFactory implements WorkFactory{
	/*
	* 给定一个性别人类，创建一个人类出来 专业术语是产生产品等级
	*/
	protected WorkerInterface createHuman(WorkFactoryEnum humanEnum) {
		WorkerInterface human = null;
		//如果传递进来不是一个Enum中具体的一个Element的话，则不处理
		if (!humanEnum.getValue().equals("")) {
			try {
				//直接产生一个实例
				human = (WorkerInterface) Class.forName(humanEnum.getValue()).newInstance();
			} catch (Exception e) {
				//因为使用了enum，这个种异常情况不会产生了，除非你的enum有问题；
				e.printStackTrace();
				}
			}
			return human;
		}
}
