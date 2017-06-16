package com.hrmsys.util;
/**
 * 查询条件校验
 * @author sux
 * @return false为空 true不为空
 */
public class ConditionValidate {
	
	public static boolean isEmpty(Object obj){
		if(obj == null || obj.equals("")){
			return false;
		}
		return true;
	}
}
