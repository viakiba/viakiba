package haust.viakiba.weather.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import haust.viakiba.weather.daily.entity.DailyRoot;
import haust.viakiba.weather.now.entity.NowRoot;
import haust.viakiba.weather.suggestion.entity.CarWashing;
import haust.viakiba.weather.suggestion.entity.Dressing;
import haust.viakiba.weather.suggestion.entity.Flu;
import haust.viakiba.weather.suggestion.entity.Sport;
import haust.viakiba.weather.suggestion.entity.SuggestionRoot;
import haust.viakiba.weather.suggestion.entity.Travel;
import haust.viakiba.weather.suggestion.entity.Uv;

import com.alibaba.fastjson.JSON;

public class ControlWeather {


	static String[] dateSan={"今天","明天","后天"};


		//获取实时天气
	public static String now2Bean (String Location_X,String Location_Y) {
		//实时天气    now.json
		// https://api.thinkpage.cn/v3/weather/now.json?key=jm9vvh9d7lxdxcze&location=beijing&language=zh-Hans&unit=c
		String now = "https://api.thinkpage.cn/v3/weather/"+"now.json?"+"key=jm9vvh9d7lxdxcze"+"&location="+Location_X+":"+Location_Y+"&language=zh-Hans&unit=c";
		String now_json = loadJson(now);

		NowRoot now_bean = JSON.parseObject(now_json, NowRoot.class);
		
		System.out.println(now_bean);
		
		String str = 	"天气状况："
						+"\n"
						+now_bean.getResults().get(0).getNow().getText()
						+"温度："
						+"\n"
						+now_bean.getResults().get(0).getNow().getTemperature();
		
		return str;
	}
	
	//获取3天内预报
	public static String daily2Bean (String Location_X,String Location_Y) {
	    //https://api.thinkpage.cn/v3/weather/daily.json?key=jm9vvh9d7lxdxcze&location=beijing&language=zh-Hans&unit=c&start=0&days=5
	    String future = "https://api.thinkpage.cn/v3/weather/daily.json?"+"key=jm9vvh9d7lxdxcze"+"&location="+Location_X+":"+Location_Y+"&language=zh-Hans&unit=c&start=0&days=4";
	    String future_json = loadJson(future);	
	    
	    DailyRoot future_bean = JSON.parseObject(future_json, DailyRoot.class);
	    System.out.println(future_bean);
	    String str="未来天气"+"\n";
	    for(int i=0;i<3;i++){
	    	//日期
	    	Date date = future_bean.getResults().get(0).getDaily().get(i).getDate();
	    	//白天
	    	String textDay = future_bean.getResults().get(0).getDaily().get(i).getTextDay();
	    	//晚上
	    	String textNight = future_bean.getResults().get(0).getDaily().get(i).getTextNight();
	    	//最高温度
	    	String high = future_bean.getResults().get(0).getDaily().get(i).getHigh();
	    	//最低温度
	    	String low = future_bean.getResults().get(0).getDaily().get(i).getLow();
	    	//降水概率
	    	String precip = future_bean.getResults().get(0).getDaily().get(i).getPrecip();
	    	//风速
	    	String windSpeed = future_bean.getResults().get(0).getDaily().get(i).getWindSpeed();
	    	
	    	str=str+dateSan[i]+"\n"
	    			 	+"白天"+textDay+"\n"
	    			 	+"晚上"+textNight+"\n"
	    			 	+"最高温度"+high+"\n"
	    			 	+"最低温度"+low+"\n"
	    			 	+"风速"+windSpeed+"\n";
	    }
	    
		return str;
	}
	
	//获取生活指数
	public static String suggestion2Bean (String Location_X,String Location_Y) {
		//https://api.thinkpage.cn/v3/life/suggestion.json?key=jm9vvh9d7lxdxcze&location=shanghai&language=zh-Hans
		String suggestion = "https://api.thinkpage.cn/v3/life/suggestion.json?"+"key=jm9vvh9d7lxdxcze"+"&location="+Location_X+":"+Location_Y+"&language=zh-Hans&unit=c";
		String suggestion_json = loadJson(suggestion);	
	    
		SuggestionRoot suggestion_bean = JSON.parseObject(suggestion_json, SuggestionRoot.class);
	    System.out.println(suggestion_bean);
	    
	    //洗车
	    CarWashing carWashing = suggestion_bean.getResults().get(0).getSuggestion().getCarWashing();
	    //穿衣
	    Dressing dressing = suggestion_bean.getResults().get(0).getSuggestion().getDressing();
		//预防疾病
	    Flu flu = suggestion_bean.getResults().get(0).getSuggestion().getFlu();
	    //运动建议
	    Sport sport = suggestion_bean.getResults().get(0).getSuggestion().getSport();
	    //出行
	    Travel travel = suggestion_bean.getResults().get(0).getSuggestion().getTravel();
	    //紫外线强度
	    Uv uv = suggestion_bean.getResults().get(0).getSuggestion().getUv();
	    
	    //字符串拼接
	    String str="生活指数"+"\n"
	    			+"穿衣:"+dressing.getDetails()
	    			+"运动建议"+sport.getDetails()
	    			+"出行建议"+travel.getDetails()
	    			+"疾病预防"+flu.getDetails()+"\n";
	    
	    return str;
	}
	
	//获取3天内预报
		public static String daily2Bean (String str) {
		    //https://api.thinkpage.cn/v3/weather/daily.json?key=jm9vvh9d7lxdxcze&location=beijing&language=zh-Hans&unit=c&start=0&days=5
		    String future = "https://api.thinkpage.cn/v3/weather/daily.json?"+"key=jm9vvh9d7lxdxcze"+"&location="+str+"&language=zh-Hans&unit=c&start=0&days=4";
		    String future_json = loadJson(future);	
		    
		    DailyRoot future_bean = JSON.parseObject(future_json, DailyRoot.class);
		    System.out.println(future_bean);
		    str="未来天气"+"\n";
		    for(int i=0;i<3;i++){
		    	//日期
		    	Date date = future_bean.getResults().get(0).getDaily().get(i).getDate();
		    	//白天
		    	String textDay = future_bean.getResults().get(0).getDaily().get(i).getTextDay();
		    	//晚上
		    	String textNight = future_bean.getResults().get(0).getDaily().get(i).getTextNight();
		    	//最高温度
		    	String high = future_bean.getResults().get(0).getDaily().get(i).getHigh();
		    	//最低温度
		    	String low = future_bean.getResults().get(0).getDaily().get(i).getLow();
		    	//降水概率
		    	String precip = future_bean.getResults().get(0).getDaily().get(i).getPrecip();
		    	//风速
		    	String windSpeed = future_bean.getResults().get(0).getDaily().get(i).getWindSpeed();
		    	
		    	str=str+dateSan[i]+"\n"
		    			 	+"白天"+textDay+"\n"
		    			 	+"晚上"+textNight+"\n"
		    			 	+"最高温度"+high+"\n"
		    			 	+"最低温度"+low+"\n"
		    			 	+"风速"+windSpeed+"\n";
		    }
			return str;
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
