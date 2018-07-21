package com.longma.chatserver.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.longma.chatserver.entity.UserInfo;

public class SessionFactoryUtil {
	
	private static SessionFactoryUtil sessionFactoryUtil;
	private SessionFactory sessionFactory;  
    
  
    private SessionFactoryUtil(){
		Configuration cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
    }
    
    public static SessionFactoryUtil getInstance(){
		if(sessionFactoryUtil == null){
			sessionFactoryUtil = new SessionFactoryUtil();
		}
		return sessionFactoryUtil;
	}
//    
    public static SessionFactory getSessions(){
		return getInstance().getSessionFactory();
	}
    
    public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
    
    /**
     * 测试 hibernate的数据源 SessionFactory
     * 通过 SessionFactoryUtil.getInstance().getSessionFactory().openSession() 获取session
     * @param args 
     * @author vk
     * 2017年7月4日
     */
    public static void main(String[] args) {
		Session session = SessionFactoryUtil.getInstance().getSessionFactory().openSession();
		
		session.beginTransaction();
		
		UserInfo userinfo = new UserInfo("321", "test", "tessat");
		session.update(userinfo);
		if(session != null){
			System.out.println(session.toString());
		}
		
		session.getTransaction().commit();
		
		session.close();
	}
}
