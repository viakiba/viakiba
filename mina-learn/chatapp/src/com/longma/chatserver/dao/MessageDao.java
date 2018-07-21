package com.longma.chatserver.dao;

import org.hibernate.classic.Session;

import com.longma.chatserver.entity.MessageInfo;
import com.longma.chatserver.utils.SessionFactoryUtil;

/**
 * 保存会话记录
 * 
 * @author vk
 * 2017年7月4日
 */
public class MessageDao {
	
	/**
	 * 记录消息
	 * @param messageInfo 
	 * @author vk
	 * 2017年7月4日
	 */
	public static void insertMessageInfo(MessageInfo messageInfo){
		Session session = SessionFactoryUtil.getSessions().openSession();
		session.beginTransaction();
		
		session.save(messageInfo);
		
		session.beginTransaction().commit();
		session.close();
	}
	
	/**
	 * 测试插入消息方法
	 * @param args 
	 * @author vk
	 * 2017年7月4日
	 */
	public static void main(String[] args) {
		MessageDao.insertMessageInfo(new MessageInfo("12", "d", "dsa","dsaa","das"));
	}
}
