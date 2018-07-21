package com.longma.chatserver.entity;

import com.alibaba.fastjson.JSON;

public class EntityFactory {
	public static Object getObj(String mess){
		String mark = mess.substring(0, 1);
		String result = mess.substring(1, mess.length());
		
		if("userinfo".equals(mark)){
			UserInfo resutlt = (UserInfo) JSON.parseObject(result, UserInfo.class);
			return resutlt;
		}else if("messageinfo".equals(mark)){
			MessageInfo resutlt = (MessageInfo) JSON.parseObject(result, MessageInfo.class);
			return resutlt;
		}
		return null;
	}
	
}
