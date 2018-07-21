package com.longma.chatserver.utils;

import java.util.Map;
import java.util.Set;

import org.apache.mina.common.IoSession;
import org.apache.mina.util.SessionLog;

import com.alibaba.fastjson.JSON;
import com.longma.chatserver.entity.MessageInfo;
import com.longma.chatserver.entity.UserInfo;


public class ClientSessionReceivedUtil implements Runnable{

	private IoSession session ;
	private Object message;
	public ClientSessionReceivedUtil(IoSession session,Object message) {
		super();
		this.session = session;
		this.message = message;
	}
	
	@Override
	public void run() {
		if(message instanceof String){
			String mess = (String) message;
//			System.out.println("原样消息》》》"+mess);
			String tag = mess.substring(0, 2);
//			System.out.println("5>>>>>>>>"+tag);
			
			switch (tag) {
				case "zc":
					String result = mess.substring(2, mess.length());
					UserInfo userinfo = JSON.parseObject(result,UserInfo.class);
					String uid = userinfo.getUid();
					if(uid != null && uid.length() > 0){
						System.out.println("================注册成功================");
						System.out.println(">>>>>>>>分配的固定uid："+uid+"<<<<<<<<");
						System.out.println(">>>>>>>请输入账号密码进行登录<<<<<<<<<<<");
//						session.setAttribute("loginstatus", "1");
						System.out.println("======================================");
					}else{
						System.out.println("==========注册失败，请重新注册=========");
					}
					break;
				
				case "dl":
					if(mess.length()>2){
						//登陆成功
						String result1 = mess.substring(2, mess.length());
						UserInfo userinfo1 = JSON.parseObject(result1,UserInfo.class);
						String uid1 = userinfo1.getUid();
						if(uid1 != null && uid1.length() > 0){
							System.out.println("=================登录成功=================");
//							System.out.println("================请输入消息类型=================");
//							System.out.println("1：全局消息 && 2:点对点消息 && 3：退出登录");
//							System.out.println("=============================================");
							//设置本地登录状态
							session.setAttribute("loginstatus", "1");
							session.setAttribute("uid", uid1);
							session.setAttribute("username", userinfo1.getUsername());
						}
					}else{
						System.out.println(">>>>>>>>>>>>登录失败，请重新登录<<<<<<<<<<<<<<<<");
						System.out.println("=====请输入zc两字进行注册或者输入其他字符登录======");
					}
					break;
					
				case "qj":
					int indexOf = 0;
					indexOf = mess.indexOf("qjvitst");
					if(mess.length() == 2){
						//System.out.println("全局发言成功");
					}else if(indexOf != -1){
						System.out.println(">>>>>体力值不足并且发言间隔过短,无法发言<<<<<<");
						System.out.println("================请输入消息类型=================");
						System.out.println("1：全局消息 && 2:点对点消息 && 3：退出登录");
						System.out.println("=============================================");
					}else{
						indexOf = mess.indexOf("qjvit");
						if(indexOf != -1){
							System.out.println(">>>>>>>>>体力值不足无法发言<<<<<<<<<<<<<");
							System.out.println("================请输入消息类型=================");
							System.out.println("1：全局消息 && 2:点对点消息 && 3：退出登录");
							System.out.println("=============================================");
						}else{
							indexOf = mess.indexOf("qjst");
							if(indexOf != -1){
								System.out.println(">>>>>>>>>>>>发言间隔过短无法发言<<<<<<<<<<<<<<<");
								System.out.println("================请输入消息类型=================");
								System.out.println("1：全局消息 && 2:点对点消息 && 3：退出登录");
								System.out.println("=============================================");
							}else{
								String result2 = mess.substring(2,mess.length());
								MessageInfo message = JSON.parseObject(result2, MessageInfo.class);
								System.out.println("=============全局消息开始======================");
								System.out.println("发送者ID>>>"+message.getUserid());
								System.out.println("发送内容>>>"+message.getContent());
								System.out.println("=============================================");
								System.out.println("================请输入消息类型=================");
								System.out.println("1：全局消息 && 2:点对点消息 && 3：退出登录");
								System.out.println("=============================================");
							}
						}
					}
					break;
				case "oo":
//					System.out.println("进入oo》》》");
					int index = 0;
					index = mess.indexOf("oovitst");
					if(mess.length() == 2){
						//System.out.println("发言成功");
					}else if(index != -1){
						System.out.println(">>>>>>>>>体力值不足并且发言间隔过短,无法发言<<<<<<<<");
						System.out.println("================请输入消息类型=================");
						System.out.println("1：全局消息 && 2:点对点消息 && 3：退出登录");
						System.out.println("=============================================");
					}else{
						index = mess.indexOf("oovit");
						if(index != -1){
							System.out.println(">>>>>>>>>体力值不足无法发言<<<<<<<<");
						}else{
							index = mess.indexOf("oost");
							if(index != -1){
								System.out.println(">>>>>>>>>发言间隔过短无法发言<<<<<<<<");
							}else{
								String result2 = mess.substring(2,mess.length());
								MessageInfo message = JSON.parseObject(result2, MessageInfo.class);
								System.out.println("==============接收oo消息================");
								System.out.println("发送者ID>>>"+message.getUserid());
								System.out.println("发送内容>>>"+message.getContent());
								System.out.println("=======================================");
								System.out.println("================请输入消息类型=================");
								System.out.println("1：全局消息 && 2:点对点消息 && 3：退出登录");
								System.out.println("=============================================");
							}
						}
					}
					break;
				case "ld":
					String resulttemp = mess.substring(2, mess.length());
					Map map = JSON.parseObject(resulttemp, Map.class);
					
					Set entrySet = map.entrySet();
					for(Object key : map.keySet() ){
						System.out.println(key+":"+map.get(key));
					}
					System.out.println("===========请输入用户的ID===========");
					break;
				case "tc":
					//System.out.println("被踢出");
					session.close();
					System.exit(0);
					break;
					
				default:
					System.out.println(">>>>>>>未知协议<<<<<<<<");
					break;
			}
			
		}else{
			System.out.println(">>>>>>>客户端接收未定义的消息类型<<<<<<<<");
		}
	}
	
}
