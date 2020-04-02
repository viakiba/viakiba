package haust.viakiba.cheat;

import java.util.Iterator;
import java.util.List;

import haust.viakiba.cheat.infogetentity.CaiPu;
import haust.viakiba.cheat.infogetentity.CaiPuRoot;
import haust.viakiba.cheat.infogetentity.HangBan;
import haust.viakiba.cheat.infogetentity.WenBen;
import haust.viakiba.cheat.infogetentity.XinWen;
import haust.viakiba.cheat.infogetentity.XinWenRoot;
import haust.viakiba.utils.PostServerCheat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Util2Info {
private static final String UTF8 = "utf-8";
	
	//申请者开发者id，实际使用时请修改成开发者自己的appKey
	private static final String apiKey = "3481dc61286a4dd396b2eb255213eb54";

	//申请成功后的证书token，实际使用时请修改成开发者自己的secret
	private static final String secret = "4753ab7b3f1a090eONOFF";

	private static final String url = "http://www.tuling123.com/openapi/api";
	
	/*
	 {
		“key”: “APIKEY”,
		“info”: “今天天气怎么样”，
		“userid”：“123456”
		} 
	 //api:   http://www.tuling123.com/openapi/api
	 */
	public static String getInfo(String info, String userid) throws Exception{
		
		//封装数据
		JSONObject json = new JSONObject();
		json.put("key", apiKey);
		json.put("info", info);
		json.put("userid", userid);
		
		//System.out.println(json.toString());
		
		//请求图灵api
		info = PostServerCheat.SendPost(json.toString(),url);
		
		//文本事件
		//System.out.println("{\"code\":100000");
		//处理json
		if(info.startsWith("{\"code\":100000")){

			WenBen wenben = JSON.parseObject(info,WenBen.class);
			StringBuffer sb = new StringBuffer();
			sb.append(wenben.getText());
			return sb.toString();
			
			//System.out.println(wenben.getCode());
		}
		
		//链接类
		//System.out.println("{\"code\":200000");
		if(info.startsWith("{\"code\":200000")){
			HangBan hangban = JSON.parseObject(info,HangBan.class);
			StringBuffer sb = new StringBuffer();
			sb.append(hangban.getText()+"\n"+hangban.getUrl());
			return sb.toString();
			//System.out.println(hangban.getText());
			//System.out.println(hangban.getUrl());
			//System.out.println(info);
		}
		
		//新闻
		//sSystem.out.println("{\"code\":302000");
		if(info.startsWith("{\"code\":302000")){
			StringBuffer sb = new StringBuffer();
			XinWenRoot xinwen = JSON.parseObject(info,XinWenRoot.class);
			String text = xinwen.getText();
			sb.append(text).append("\n");
			List<XinWen> list = xinwen.getList();
			Iterator<XinWen> i = list.iterator();
			while(i.hasNext()){
				XinWen xinwendetail = i.next();
				sb.append(xinwendetail.getArticle()+"\n" + xinwendetail.getSource()+"\n"+xinwendetail.getDetailurl()+"\n"+"\n");
			}
			//	System.out.println("=========================");
			//System.out.println(info);
			return sb.toString();
		}
		
		//菜谱
		//System.out.println("{\"code\":308000");
		if(info.startsWith("{\"code\":308000")){
			StringBuffer sb = new StringBuffer();
			CaiPuRoot caipu = JSON.parseObject(info,CaiPuRoot.class);
			String text = caipu.getText();
			sb.append(text).append("\n");
			List<CaiPu> list = caipu.getList();
			Iterator<CaiPu> i = list.iterator();
			sb.append(i.next().getName());
			while(i.hasNext()){
				CaiPu caidetail = i.next();
				sb.append("\n" + caidetail.getDetailurl());
			}
			//System.out.println("=========================");
			return sb.toString();
		}
		
		return info;
	}
	
}
