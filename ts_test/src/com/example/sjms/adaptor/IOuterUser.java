package com.example.sjms.adaptor;

import java.util.Map;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年8月1日
 */

public interface IOuterUser {
	//基本信息，比如名称，性别，手机号码了等
	public Map getUserBaseInfo();
	//工作区域信息
	public Map getUserOfficeInfo();
	//用户的家庭信息
	public Map getUserHomeInfo();
}
