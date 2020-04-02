package haust.viakiba.utils;

import haust.viakiba.entity.MessageTextBean;

import java.util.Date;
import java.util.Map;

public class DefaultMessage {
	public static MessageTextBean getMessageDefault2Bean(Map<String,String> map){
		MessageTextBean mtb=new MessageTextBean();

		mtb.setToUserName(map.get("FromUserName"));
		mtb.setFromUserName(map.get("ToUserName"));
		
		mtb.setContent("2.1 \n 新增 语音翻译（尝试说   翻译 happy），语音查新闻(说新闻)，等众多功能。试着说一下你想说的，看会回复什么？\n 2.0  \n 新增   快递(m+快递号 如  m1234567891011)，对话功能（支持语音和文本）\n 1.1  \n 新增翻译功能 接入了百度翻译 (如（大小写不敏感 下同） 翻译成中文  tzhappy，翻译成日文 tj你好 ，翻译成韩文，th你好 ，翻译成英文 te你好)\n 1.0 \n  支持天气查询（众多查询姿势，比如语音 说（郑州天气），发送坐标 （点击邮编加号，选择发送为止），\n发送 w+城市名称（wbeijing/Wbeijing）  ）\n 源码：\n www.github.com/viakiba/wechatvk");
		mtb.setMsgType("text");
		mtb.setCreateTime(new Date().getTime());
		mtb.setMsgId(map.get("MsgId"));
		return mtb;
	}
}
