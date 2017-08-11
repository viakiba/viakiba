package com.example.sjms.abstractfactory.factory;


/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月31日
 */

public enum WorkFactoryEnum {
	programerimplnan("com.example.sjms.abstractfactory.entity.ProgramerImplNan"),
	programerimplnv("com.example.sjms.abstractfactory.entity.ProgramerImplNv"),
	teacherimplnv("com.example.sjms.abstractfactory.entity.TeacherImplNv"),
	teacherimplnan("com.example.sjms.abstractfactory.entity.TeacherImplNan");
	
	private String value = "";
	private WorkFactoryEnum(String value){
		this.value = value;
	}
	//定义构造函数，目的是Data(value)类型的相匹配
	public String getValue(){
		return this.value;
	}
	
}
