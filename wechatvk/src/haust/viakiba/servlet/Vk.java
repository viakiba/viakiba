package haust.viakiba.servlet;

import haust.viakiba.cheat.CheatMain;
import haust.viakiba.cheat.Util2Info;
import haust.viakiba.entity.MessageLocationBean;
import haust.viakiba.entity.MessageTextBean;
import haust.viakiba.mail.MailMain;
import haust.viakiba.translate.TransBaidu;
import haust.viakiba.utils.Bean2TextXml;
import haust.viakiba.utils.DefaultMessage;
import haust.viakiba.utils.MessageLocation2Bean;
import haust.viakiba.utils.MessageText2Bean;
import haust.viakiba.utils.MessageVoice2Bean;
import haust.viakiba.utils.Sha1;
import haust.viakiba.utils.XmlExceptionDefault;
import haust.viakiba.utils.XmlJson2Map;
import haust.viakiba.weather.main.ControlWeather;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Element;

/**
 * 微信进入的地方 
 * 主要进行事件控制
 * @author viakiba
 *
 */
public class Vk extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		/***/
		System.out.println("=================================");
		System.out.println(timestamp);
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		String token = "viakiba";
		
		//验证配置
		String signCompar = Sha1.getSHA1(token, timestamp, nonce);
		
		PrintWriter pw = resp.getWriter();
		
		if(signCompar.equals(signature)){
			pw.print(echostr);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = resp.getWriter();
		
		try {
			
			Map<String, String> map = XmlJson2Map.toMap(req);
			
			String MsgType = map.get("MsgType");
			
			
		
			switch(MsgType){	
				
				//文本消息
				case "text":
					MessageTextBean mtb = MessageText2Bean.getMessageText2Bean(map);
					String content = mtb.getContent();
					//事件控制
					//字符串截取首字母  判断事件
					char target = content.charAt(0);
					switch(target){
						//翻译 事件
						case 't' :
							mtb.setToUserName(map.get("FromUserName"));
							mtb.setFromUserName(map.get("ToUserName"));
							mtb.setCreateTime(new Date().getTime());
							mtb.setMsgType("text");
							mtb.setMsgId(map.get("MsgId"));

							content = TransBaidu.tranBd(content);
							
							mtb.setContent("翻译："+content);
							String textXml1 = Bean2TextXml.beantoTextXml(mtb);
							//System.out.println(textXml1);
								
							pw.print(textXml1);
							break;
						case 'T' :
							mtb.setToUserName(map.get("FromUserName"));
							mtb.setFromUserName(map.get("ToUserName"));
							mtb.setCreateTime(new Date().getTime());
							mtb.setMsgType("text");
							mtb.setMsgId(map.get("MsgId"));

							content = TransBaidu.tranBd(content);
							mtb.setContent("翻译："+content);
							String textXml2 = Bean2TextXml.beantoTextXml(mtb);
							//System.out.println(textXml2);
								
							pw.print(textXml2);
							break;
						//天气
						case 'w' :
							mtb=MessageLocation2Bean.getMessageText2Bean(map);
							String textXml3 = Bean2TextXml.beantoTextXml(mtb);
							//System.out.println(textXml3);
								
							pw.print(textXml3);
							break;
						case 'W' : 
							mtb=MessageLocation2Bean.getMessageText2Bean(map);
							String textXml4 = Bean2TextXml.beantoTextXml(mtb);
							//System.out.println(textXml4);
								
							pw.print(textXml4);
							break;
						//邮件
						case 'm' :
							mtb=MailMain.getHttp(map);
							String textXml5 = Bean2TextXml.beantoTextXml(mtb);
							//System.out.println(textXml5);
								
							pw.print(textXml5);
							break;
						case 'M' :
							mtb=MailMain.getHttp(map);
							String textXml6 = Bean2TextXml.beantoTextXml(mtb);
							//System.out.println(textXml6);
							pw.print(textXml6);
							break;
						// 注释   文本消息无对应 选择聊天机器人
						default:
							mtb=CheatMain.getMessageTextBean(map);
							//文本
							mtb = CheatMain.getMessageTextBean(map);
							String textXml7 = Bean2TextXml.beantoTextXml(mtb);
							//System.out.println(textXml7);
							pw.print(textXml7);
							break;
						} 
					break;
					
					case "location":
							MessageTextBean messageTextBean = MessageLocation2Bean.getMessageLocation2Bean(map);
							String textXml8 = Bean2TextXml.beantoTextXml(messageTextBean);
							//System.out.println(textXml8);
							
							pw.print(textXml8);
							break;
					//添加语音消息
					case "voice":
						MessageTextBean messagevoice = MessageVoice2Bean.getMessageVoice2Bean(map);
						String textXml9 = Bean2TextXml.beantoTextXml(messagevoice);
						//System.out.println(textXml9);
						
						pw.print(textXml9);
						break;
					//点击按钮事件
					case "event":
						String subscribe=map.get("Event");
						
						if("subscribe".equals(subscribe)){
							MessageTextBean messageTextBeanDefault = DefaultMessage.getMessageDefault2Bean(map);
							String textXml10 = Bean2TextXml.beantoTextXml(messageTextBeanDefault);
							//System.out.println(textXml10);
							
							pw.print(textXml10);
						}
						break;
						
					//添加无法响应的事件	
					default :
						MessageTextBean messageTextBeanDefault = DefaultMessage.getMessageDefault2Bean(map);
						String textXml10 = Bean2TextXml.beantoTextXml(messageTextBeanDefault);
						
						pw.print(textXml10);
						break;
			} 
	}catch (Exception e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
}
