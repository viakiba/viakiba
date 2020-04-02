package haust.viakiba.cheat;

import haust.viakiba.entity.MessageTextBean;

import java.util.Date;
import java.util.Map;

public class CheatMain {
		
	public static MessageTextBean getMessageTextBean(Map<String, String> map) throws Exception{
		MessageTextBean mtb = new MessageTextBean();
		
		String userid=map.get("FromUserName");
		String info=map.get("Content");
		//处理对话
		info = Util2Info.getInfo(info, userid);
		
		
		
		
		
		mtb.setToUserName(map.get("FromUserName"));
		mtb.setFromUserName(map.get("ToUserName"));
		mtb.setContent(info);
		mtb.setCreateTime(new Date().getTime());
		mtb.setMsgId(map.get("MsgId"));
		mtb.setMsgType(map.get("MsgType"));
		
		return mtb;
	}
}
