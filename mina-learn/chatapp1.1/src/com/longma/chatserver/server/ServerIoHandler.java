package com.longma.chatserver.server;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoHandler;
import org.apache.mina.common.IoSession;

import com.alibaba.fastjson.JSON;
import com.longma.chatserver.dao.ChatUserInfoDao;
import com.longma.chatserver.entity.MessageInfo;
import com.longma.chatserver.entity.UserInfo;
import com.longma.chatserver.utils.SnowflakeIdUtil;

public class ServerIoHandler implements IoHandler{
	
	//保存所有客户端已登录的会话  uid,session
	private final static Map<String,IoSession> sessions = Collections.synchronizedMap(new Hashtable<String,IoSession>());
	
	static{
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				System.out.println("定时任务执行中");
				Set<Entry<String, IoSession>> set = sessions.entrySet();
				for(Entry<String, IoSession> entry : set){
					String key = entry.getKey();
					IoSession ioSession = sessions.get(key);
					
					int vit = Integer.valueOf(ioSession.getAttribute("vit").toString());
					
					System.out.println("当前用户ID"+key);
					System.out.println("开始添加在线用户体力值，当前为："+(vit+20));
					System.out.println(ioSession.getAttribute("st"));
					
					String st = ioSession.getAttribute("st").toString();
					
					Long temp = System.currentTimeMillis() - Long.valueOf(st);
					
					if(temp > 120000){
						ioSession.write("tc");
						System.out.println(ioSession.getAttribute("username")+"====>>长时间不说话踢出");
						broadCast(ioSession,ioSession.getAttribute("username").toString(),ioSession.getAttribute("username").toString()+"====>>长时间不说话踢出");
						sessions.remove(key);
						try {
							Thread.currentThread().sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ioSession.close();
					}
					
					ioSession.setAttribute("vit", vit+20);
				}
			}
		};
		timer.schedule(timerTask, 1000, 30000);
	}
	
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		if(message instanceof String){
			String temp = (String) message;
			String tag = temp.substring(0, 2);
			System.out.println(tag);
			temp = temp.substring(2, temp.length());
			
			switch(tag){
				case "zc":
					//测试客户端根据userinfo的id进行判断是否注册成功 id不为空就是注册成功
					
					System.out.println("注册的信息："+temp);
					UserInfo userinfo = JSON.parseObject(temp, UserInfo.class);
					//查询用户名是否存在
					UserInfo usertemp = ChatUserInfoDao.selectUserByName(userinfo);
					if(usertemp == null){
						//允许执行注册
						SnowflakeIdUtil snowflakeIdUtil = new SnowflakeIdUtil();
						long id = snowflakeIdUtil.nextId();
						userinfo.setUid(""+id);
						ChatUserInfoDao.insertUserInfo(userinfo);
						//相应客户端
						session.write("zc"+JSON.toJSONString(userinfo));
					}else{
						//已存在注册失败
						session.write("zc"+JSON.toJSONString(userinfo));
					}
					break;
				
				case "dl":
					System.out.println("登陆的凭证:"+temp);
					
					UserInfo userInfo = JSON.parseObject(temp, UserInfo.class);
					UserInfo tempUser = ChatUserInfoDao.selectUserByNameAndPass(userInfo);
					if(tempUser == null){
						//登录失败
						session.write("dl");
					}else{
						//登录成功
						sessions.put(tempUser.getUid(),session);
						//初始体力值
						session.setAttribute("vit",100);
						session.setAttribute("username",tempUser.getUsername());
						session.setAttribute("uid",tempUser.getUid());
						//初始发言时间
						session.setAttribute("st",System.currentTimeMillis()+"");
						//广播通知
						broadCast(session, tempUser.getUsername(), tempUser.getUsername()+"进入了聊天系统");
						session.write("dl"+JSON.toJSONString(tempUser));
					}
					break;
					
				case "qj":
					System.out.println("全局消息");
					String vit = session.getAttribute("vit").toString();
					String st = session.getAttribute("st").toString();
					
					long sttemp =System.currentTimeMillis() - Long.valueOf(st);
					
					System.out.println("当前用户的发言时间间隔》》》"+sttemp);
					
					if(Integer.valueOf(vit)>10 && sttemp > 2000){
						MessageInfo messageinfo = JSON.parseObject(temp,MessageInfo.class);
						String userid = messageinfo.getUserid();
						String content = messageinfo.getContent();
						
						broadCast(session, userid, content);
						session.setAttribute("vit",Integer.valueOf(vit)-10);
						session.setAttribute("st", System.currentTimeMillis());
						
						session.write("qj");
					}else{
						if(Integer.valueOf(vit)<10 && sttemp < 2000){
							session.write("qjvitst");
						}else if(Integer.valueOf(vit)<10){
							session.write("qjvit");
						}else{
							session.write("qjst");
						}
					}
					break;
					
				case "oo":
					System.out.println("点对点消息");
					
					String vits = session.getAttribute("vit").toString();
					String sts = session.getAttribute("st").toString();
					
					long sttemps =System.currentTimeMillis() - Long.valueOf(sts);
					System.out.println("当前用户的发言时间间隔》》》"+sttemps);
					if(Integer.valueOf(vits)>10 && sttemps > 2000){
						MessageInfo messageinfo = JSON.parseObject(temp,MessageInfo.class);
						
						String userid = messageinfo.getUserid();
						String content = messageinfo.getContent();
						String tuserid = messageinfo.getTuserid();
								
						IoSession tsession = sessions.get(tuserid);
						
						session.setAttribute("vit",Integer.valueOf(vits)-10);
						session.setAttribute("st", System.currentTimeMillis());
						
						MessageInfo messageInfo2 = new MessageInfo();
						messageInfo2.setContent(content);
						messageInfo2.setUserid(userid);
						tsession.write("oo"+JSON.toJSONString(messageInfo2));
						session.write("oo");
					}else{
						if(Integer.valueOf(vits)<10 && sttemps < 2000){
							session.write("oovitst");
						}else if(Integer.valueOf(vits)<10){
							session.write("oovit");
						}else{
							session.write("oost");
						}
					}
					break;
				case "ld":
					Map map = new HashMap<>();
					
					synchronized (sessions) {
						Set<Entry<String, IoSession>> set = sessions.entrySet();
						for(Entry<String, IoSession> entry : set){
							String key = entry.getKey();	
							IoSession sessiontemp = sessions.get(key);
							String nametemp = sessiontemp.getAttribute("username").toString();
							map.put(key, nametemp);
						}
					}
					String s = JSON.toJSONString(map);
					session.write("ld"+s);
					break;
				default:
					System.out.println(temp);
					System.out.println("无法识别的信息头");
					break;
			}
		}else{
			session.write("cw");
		}
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus idle) throws Exception {
		//空闲超过两分钟  移除其会话
		
//		sessions.remove(session.getAttribute("uid"));
//		session.close();
//		session.write("tc");
		
	}

	/**
	 * 点对点消息
	 * @param uid
	 * @param tuid
	 * @param Message 
	 * @author vk
	 * 2017年7月4日
	 */
	public void chatO2O(String uid,String username,String tuid,String message){
		IoSession session = sessions.get(tuid);
		session.write(username.length()+":"+uid+":"+username+":"+tuid+message);
	}
	
	/**
	 * 广播消息
	 * @param username
	 * @param message 
	 * @author vk
	 * 2017年7月4日
	 */
	public static void broadCast(IoSession session,String username,String message){
		System.out.println("用户"+username+":"+message);
		synchronized (sessions) {
			Set<Entry<String, IoSession>> set = sessions.entrySet();
			for(Entry<String, IoSession> entry : set){
//				if(entry != session){
					MessageInfo messageInfo = new MessageInfo();
					messageInfo.setContent(message);
					messageInfo.setUserid(session.getAttribute("uid").toString());
					String result = JSON.toJSONString(messageInfo);
					entry.getValue().write("qj"+result);
//				}
			}
		}
	}
	
	/**
	 * 用户退出，移除他的会话
	 */
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("有新用户正常退出服务器");
		sessions.remove(session.getAttribute("uid"));
		broadCast(session,session.getAttribute("username").toString(),"退出");
	}
	
	/**
	 * 会话出现异常  移除他的会话
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable throwable) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("部分客户端会话出现异常");
//		System.out.println(throwable.getMessage());
		//会话出现异常  移除他的会话
		sessions.remove(session.getAttribute("uid"));
		//通知所有人
		broadCast(session,session.getAttribute("username").toString(),"异常退出");
		session.write("tc");
		session.close();
	}
	
	/**
	 * 打开一个会话，并设置空闲参数
	 */
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		//设置空闲参数  2分钟
		session.setIdleTime(IdleStatus.BOTH_IDLE, 120000);
		System.out.println("有客户端打开一个连接并尝试注册或者登录服务器");
	}
	
	/**
	 * 客户端创建一个session会话
	 */
	@Override
	public void sessionCreated(IoSession session) throws Exception {
//		System.out.println("有客户端创建一个session会话");
	}
	
	/**
	 * 服务器主动向客户端发消息
	 */
	@Override
	public void messageSent(IoSession session, Object obj) throws Exception {
//		System.out.println("服务器主动向客户端发消息");
	}
}
