package com.longma.chatserver.utils;

import java.util.Scanner;

import org.apache.mina.common.IoSession;

import com.alibaba.fastjson.JSON;
import com.longma.chatserver.entity.MessageInfo;
import com.longma.chatserver.entity.UserInfo;

/**
 * 客户端使用的输入工具类
 * 
 * @author vk
 * 2017年7月6日
 */
public class ScannerUtil implements Runnable{
	
	private IoSession session ;
	
	public ScannerUtil(IoSession session) {
		super();
		this.session = session;
	}
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		for(;;){
			
			if(session.getAttribute("loginstatus") == null){
				System.out.println("请输入账号登录或者输入zc两字进行注册：");
			}else{
				System.out.println("请输入消息类型");
			}
			
			if(scanner.hasNext()){
				if(session.getAttribute("loginstatus") == null){
					String tag = scanner.nextLine();
					if("zc".equalsIgnoreCase(tag)){
						System.out.println("请输入需要注册的账号名称");
						String account = scanner.nextLine();
						if(account != null && account.length() > 0){
							System.out.println("请输入需要注册的账号的密码：");
							String password = scanner.nextLine();
							System.out.println("请重新输入需要注册的账号的密码：");
							String repassword = scanner.nextLine();
							if(password != null && password.length() > 0 && repassword != null && repassword.length() > 0){
								if(password.equals(repassword)){
									UserInfo userInfo = new UserInfo();
									userInfo.setPassword(password);
									userInfo.setUsername(account);
									String result = JSON.toJSONString(userInfo);
									session.write("zc"+result);
								}else{
									System.out.println("两次密码输入不一致!!!");
								}
							}else{
								System.out.println("密码长度为0不符合规范!!!");
							}
						}else{
							System.out.println("账号长度为0，不符合规范!!!");
						}
						
					}else{
						System.out.println("请输入需要登录的账号名称");
						String account = scanner.nextLine();
						System.out.println("请输入需要登录账号的密码");
						String password = scanner.nextLine();
						if(password != null && password.length() > 0 && account != null && account.length() > 0){
							UserInfo userInfo = new UserInfo();
							userInfo.setPassword(password);
							userInfo.setUsername(account);
							String result = JSON.toJSONString(userInfo);
							session.write("dl"+result);
						}else{
							System.out.println("账号密码的格式不符合规范");
						}
					}
				}else{
					//已经登录，可以发言
					System.out.println("请输入需要发送的消息类型对应的数字");
					System.out.println("1：全局消息 && 2:点对点消息 && 3：退出登录");
					String tag = scanner.nextLine();
					if("1".equals(tag)){
						MessageInfo messageInfo = new MessageInfo();
						
						String uid = session.getAttribute("uid").toString();
						messageInfo.setUserid(uid);
						System.out.println("请输入消息的内容");
						String content = scanner.nextLine();
						messageInfo.setContent(content);
						String result = JSON.toJSONString(messageInfo);
						session.write("qj"+result);
						
					}else if("2".equals(tag)){
						String uid = session.getAttribute("uid").toString();
						System.out.println("输入1，跳过id列表的获取；输入其他值，获取用户的列表ID");
						String idtag = scanner.nextLine();
						if("1".equals(idtag)){
							MessageInfo mess = new MessageInfo();
							System.out.println("请输入消息对象的ID");
							String id = scanner.nextLine();
							if(id != null && id.length() > 0 ){
								mess.setTuserid(id);
								System.out.println("请输入需要发送的消息内容");
								String content = scanner.nextLine();
								mess.setContent(content);
								mess.setUserid(uid);
								String result = JSON.toJSONString(mess);
								session.write("oo"+result);
							}else{
								System.out.println("ID不符合规范");
							}
						}else{
							session.write("ld");
							MessageInfo mess = new MessageInfo();
							System.out.println("请输入消息对象的ID");
							String id = scanner.nextLine();
							if(id != null && id.length() > 0 ){
								mess.setTuserid(id);
								System.out.println("请输入需要发送的消息内容");
								String content = scanner.nextLine();
								mess.setContent(content);
								mess.setUserid(uid);
								String result = JSON.toJSONString(mess);
								session.write("oo"+result);
							}else{
								System.out.println("ID不符合规范");
							}
						}
					}else if("3".equals(tag)){
						session.close();
						System.out.println("退出成功");
						System.exit(0);
					}else{
					}
						System.out.println("消息类型无效，请重新输入");
					}
				}
			}
		}
	}