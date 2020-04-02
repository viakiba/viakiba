package haust.viakiba.mail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import haust.viakiba.entity.MessageTextBean;
import haust.viakiba.mail.business.JsonsRootBeanGs;
import haust.viakiba.mail.state.JsonsRootBeanDh;
import haust.viakiba.mail.state.Traces;
import haust.viakiba.utils.JdbcUtil;

public class MailMain {
	public static MessageTextBean getHttp(Map<String, String> map) throws Exception{
		MessageTextBean mtb=new MessageTextBean();  //
		
		String dh=map.get("Content").substring(1);
		System.out.println(dh);
		
		boolean isNum = isNumeric(dh);
		//判断是否全为数字
		if(!isNum){
			mtb.setToUserName(map.get("FromUserName"));
			mtb.setFromUserName(map.get("ToUserName"));
			mtb.setContent("单号错误  数字问题");
			mtb.setCreateTime(new Date().getTime());
			mtb.setMsgId(map.get("MsgId"));
			mtb.setMsgType(map.get("MsgType"));
			
			return mtb;
		}
		
		/*//判断是否为13位数字
		if(dh.length() != 13){
			mtb.setToUserName(map.get("FromUserName"));
			mtb.setFromUserName(map.get("ToUserName"));
			mtb.setContent("单号错误  单号不为为13位");
			mtb.setCreateTime(new Date().getTime());
			mtb.setMsgId(map.get("MsgId"));
			mtb.setMsgType(map.get("MsgType"));
			
			return mtb;
		}*/
		//查询公司
		JsonsRootBeanGs gs = KdApiOrderDistinguish.getJsonsRootBean(dh);
		
		if(gs == null){
			mtb.setToUserName(map.get("FromUserName"));
			mtb.setFromUserName(map.get("ToUserName"));
			mtb.setContent("单号错误 公司不存在");
			mtb.setCreateTime(new Date().getTime());
			mtb.setMsgId(map.get("MsgId"));
			mtb.setMsgType(map.get("MsgType"));
			
			return mtb;
		}
		
		//获取公司代码
		String gscode = gs.getShippers().get(0).getShippercode();
		String gsName = gs.getShippers().get(0).getShippername();
		
		/*//连接数据库    主要放三个字段    OpenID  ， dh 单号，gscode 公司代码 ， 初次查询时间   插入
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		String currenttime = sdf.format(date);
		Connection conn = JdbcUtil.getConnection();
		String sql = "insert into user(openid,gscode,dhcode,time) values(?,?,?,?)";
		PreparedStatement pstate = conn.prepareStatement(sql);
		pstate.setString(0, mtb.getFromUserName());
		pstate.setString(1, gscode);
		pstate.setString(2,	dh);
		pstate.setString(3,	currenttime);
		int count = pstate.executeUpdate();
		
		pstate.close();
		conn.close();
		*/
		
		//查询快递状态
		JsonsRootBeanDh state = KdniaoTrackQueryAPI.getJsonsRootBean(gscode, dh);
		String content = null;
		StringBuffer sb = new StringBuffer();
		boolean success = state.getSuccess();
		if(!success){
			mtb.setToUserName(map.get("FromUserName"));
			mtb.setFromUserName(map.get("ToUserName"));
			mtb.setContent("单号错误  单号查询失败 估计不存在");
			mtb.setCreateTime(new Date().getTime());
			mtb.setMsgId(map.get("MsgId"));
			mtb.setMsgType(map.get("MsgType"));
			
			return mtb;
		}
		List<Traces> traces = state.getTraces();
		sb.append(gsName+"\n").append(dh+"\n");
		
		Traces lastTraces = traces.get(traces.size()-1);
		
		sb.append(lastTraces.getAccepttime()+"\n");//时间
		sb.append(lastTraces.getAcceptstation()+"\n");//状态
		
		content = sb.toString();
		//更新操作
		String fromUserName = map.get("FromUserName");
		
		
		System.out.println(content);
		
		mtb.setToUserName(map.get("FromUserName"));
		mtb.setFromUserName(map.get("ToUserName"));
		mtb.setContent(content);
		mtb.setCreateTime(new Date().getTime());
		mtb.setMsgId(map.get("MsgId"));
		mtb.setMsgType(map.get("MsgType"));
		
		return mtb;
	}
	
	public static boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
}
