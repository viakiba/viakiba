package haust.viakiba.utils;

import haust.viakiba.entity.MessageTextBean;

import java.util.Date;
import java.util.Map;

public class MessageText2Bean {

	public static MessageTextBean getMessageText2Bean(Map<String, String> map) {
		MessageTextBean mtb = new MessageTextBean();
		
		mtb.setToUserName(map.get("FromUserName"));
		mtb.setFromUserName(map.get("ToUserName"));
		mtb.setContent(map.get("Content"));
		mtb.setMsgType(map.get("MsgType"));
		mtb.setCreateTime(new Date().getTime());
		mtb.setMsgId(map.get("MsgId"));
		
		System.out.println(mtb.toString());
		
		return mtb;
	}
	
}
