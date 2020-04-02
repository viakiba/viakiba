package haust.viakiba.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import haust.viakiba.entity.MessageLocationBean;
import haust.viakiba.entity.MessageTextBean;
import haust.viakiba.weather.daily.entity.DailyRoot;
import haust.viakiba.weather.main.ControlWeather;
import haust.viakiba.weather.now.entity.NowRoot;
import haust.viakiba.weather.suggestion.entity.SuggestionRoot;
/**
 * 获取的地址信息转化为地址对象     返回文本对象
 * 
 * @author viakiba
 *
 */
public class MessageLocation2Bean {
	public static MessageTextBean getMessageLocation2Bean(Map<String,String> map){
		MessageTextBean mtb=new MessageTextBean();
		/**
		    ToUserName	开发者微信号
			FromUserName	发送方帐号（一个OpenID）
			CreateTime	消息创建时间 （整型）
			MsgType	location
			Location_X	地理位置维度
			Location_Y	地理位置经度
			Scale	地图缩放大小
			Label	地理位置信息
			MsgId	消息id，64位整型
		 */
		mtb.setToUserName(map.get("FromUserName"));
		mtb.setFromUserName(map.get("ToUserName"));
		
		//公共的url
		String publicUrl="https://api.thinkpage.cn/v3/";
		//获取 坐标信息
		String Location_X=map.get("Location_X");
		String Location_Y=map.get("Location_Y");
		
		//使用经纬度默认获取实时最完善的天气
		String str = ControlWeather.daily2Bean( Location_X, Location_Y);
		
		mtb.setContent(str);
		mtb.setMsgType("text");
		mtb.setCreateTime(new Date().getTime());
		mtb.setMsgId(map.get("MsgId"));
		
		return mtb;
	}
	
	public static MessageTextBean getMessageText2Bean(Map<String,String> map){
		MessageTextBean mtb = new MessageTextBean();
		mtb.setToUserName(map.get("FromUserName"));
		mtb.setFromUserName(map.get("ToUserName"));
		
		//公共的url
		//https://api.thinkpage.cn/v3/weather/daily.json?key=jm9vvh9d7lxdxcze&location=beijing&language=zh-Hans&unit=c&start=0&days=4
		String local = map.get("Content");
		
		System.out.println(local.substring(1));
		
		String str2 = ControlWeather.daily2Bean(local.substring(1));
		
		mtb.setContent(str2);
		mtb.setMsgType("text");
		mtb.setCreateTime(new Date().getTime());
		mtb.setMsgId(map.get("MsgId"));
		
		return mtb;
	}
	
	//返回json字符串
	public static String loadJson (String url) {  
		       StringBuilder json = new StringBuilder();  
		       try {  
		           URL urlObject = new URL(url);  
		           URLConnection uc = urlObject.openConnection();  
		           BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));  
		           String inputLine = null;  
		           while ( (inputLine = in.readLine()) != null) {  
		              json.append(inputLine);  
		           }  
		           in.close();  
		         } catch (Exception e) {  
		             e.printStackTrace();  
		         }  
		         return json.toString();  
		     }
}
