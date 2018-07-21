package com.longma.chatserver.utils;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.longma.chatserver.entity.UserInfo;

public class SessionFactoryUtil {
	
	private static SessionFactoryUtil sessionFactoryUtil;
	private SessionFactory sessionFactory;  
    
  
    private SessionFactoryUtil(){
    	String path = getRootPathWithoutSlash("hibernate.cfg.xml");
		System.out.println("dbpath:"+path);
		Configuration cfg = new Configuration().configure(new File(path));
		sessionFactory = cfg.buildSessionFactory();
    }
    
    private SessionFactoryUtil(File file){
    	Configuration cfg = new Configuration().configure(file);
    	sessionFactory = cfg.buildSessionFactory();
    }
    
    public static String getRootPathWithoutSlash(String resourceFileName){
		try{
			return SessionFactoryUtil.class.getResource("/"+resourceFileName).getPath();
		}
		catch(Exception e){
			return System.getProperty("user.dir")+"/"+resourceFileName;
		}
	}
    
    public static void initialize(File filename){
    	sessionFactoryUtil = new SessionFactoryUtil(filename);
	}
    
    public static SessionFactoryUtil getInstance(){
		if(sessionFactoryUtil == null){
			sessionFactoryUtil = new SessionFactoryUtil();
		}
		return sessionFactoryUtil;
	}
    
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
