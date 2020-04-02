package haust.viakiba.utils;

import java.util.Date;
import java.util.Map;

import haust.viakiba.cheat.Util2Info;
import haust.viakiba.entity.MessageTextBean;

public class MessageVoice2Bean {
	public static MessageTextBean getMessageVoice2Bean(Map<String,String> map) throws Exception{
		MessageTextBean mtb=new MessageTextBean();
		/*
		 	ToUserName	开发者微信号
			FromUserName	发送方帐号（一个OpenID）
			CreateTime	消息创建时间 （整型）
			MsgType	语音为voice
			MediaID	语音消息媒体id，可以调用多媒体文件下载接口拉取该媒体
			Format	语音格式：amr
			Recognition	语音识别结果，UTF8编码
			MsgID	消息id，64位整型
		 */
		
		
		/*
		 <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>1357290913</CreateTime>
		<MsgType><![CDATA[voice]]></MsgType>
		<MediaId><![CDATA[media_id]]></MediaId>
		<Format><![CDATA[Format]]></Format>
		<Recognition><![CDATA[腾讯微信团队]]></Recognition>
		<MsgId>1234567890123456</MsgId>
		</xml>
		 */
		mtb.setToUserName(map.get("FromUserName"));
		mtb.setFromUserName(map.get("ToUserName"));
		
		
		String recognition = map.get("Recognition");
		String userid = map.get("FromUserName");
		String info = Util2Info.getInfo(recognition, userid);
		
		mtb.setCreateTime(new Date().getTime());
		mtb.setContent(info);
		mtb.setMsgType("text");
		mtb.setMsgId(map.get("MsgId"));
		
		return mtb;
	}
}
