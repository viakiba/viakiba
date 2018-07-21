package com.longma.chatserver.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.longma.chatserver.entity.UserInfo;
import com.longma.chatserver.utils.SessionFactoryUtil;

/**
 * 用户注册与登录的数据库相关操作
 * 
 * @author vk
 * 2017年7月4日
 */
public class ChatUserInfoDao {

	/**
	 * 执行用户注册操作 写入数据库
	 * @param userInfo 
	 * @author vk
	 * 2017年7月4日
	 */
	public static void insertUserInfo(UserInfo userInfo){
		Session session = SessionFactoryUtil.getSessions().openSession();
		session.beginTransaction();
		
		session.save(userInfo);
		
		session.beginTransaction().commit();
		session.close();
	}
	
	/**
	 * 根据用户名和密码判断是否存在此用户
	 * 登录时进行使用
	 * @param userInfo
	 * @return 
	 * @author vk
	 * 2017年7月4日
	 */
	public static UserInfo selectUserByNameAndPass(UserInfo userInfo){
		Session session = SessionFactoryUtil.getSessions().openSession();
		session.beginTransaction();
		
		String sql = "select * from user_info where username = \""+userInfo.getUsername()+"\" and password = \""+userInfo.getPassword()+"\"";
		Query query = session.createSQLQuery(sql).addEntity(UserInfo.class);
		List<UserInfo> list = query.list();
		if(list.size() > 0){
			System.out.println(list.get(0).toString());
			return list.get(0);
		}
		session.beginTransaction().commit();
		session.close();
		return null;
	}
	
	/**
	 * 根据username判断是否含有此name的用户  
	 * 注册时可以使得用户名唯一
	 * @param userInfo
	 * @return 
	 * @author vk
	 * 2017年7月4日
	 */
	public static UserInfo selectUserByName(UserInfo userInfo){
		Session session = SessionFactoryUtil.getSessions().openSession();
		session.beginTransaction();
		
		String sql = "select * from user_info where username = \""+userInfo.getUsername()+"\"";
		Query query = session.createSQLQuery(sql).addEntity(UserInfo.class);
		List<UserInfo> list = query.list();
		if(list.size() > 0){
			System.out.println(list.get(0).toString()+"查询人员");
			return list.get(0);
		}
		session.beginTransaction().commit();
		session.close();
		
		return null;
	}
	
	/**
	 * 测试查询与插入是否符合需求
	 * @param args 
	 * @author vk
	 * 2017年7月4日
	 */
	public static void main(String[] args) {
		//ChatUserDao.selectUserByNameAndPass(new UserInfo("1", "test", "test"));
		
		//ChatUserDao.selectUserByName(new UserInfo("1", "test", "test"));
		//ChatUserDao.insertUserInfo(new UserInfo("1", "test", "test"));
	}
	
}
