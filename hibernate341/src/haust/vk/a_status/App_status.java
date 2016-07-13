package haust.vk.a_status;


import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App_status {
	private static SessionFactory sf;
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(User.class)
				 .buildSessionFactory();
	}
	
	//
	@Test
	public void testSaveset() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//创建对象   临时状态
		User user = new User();
		user.setUserName("UserName1");
		
		//保存   持久化状态
		session.save(user);
		user.setUserName("ceshi");//反映到数据库中
		session.beginTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGetset() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//获取对象
		User user =(User) session.get(User.class, 1);
		System.out.println(user.getUserId()+"--"+user.getUserName());
		
		//
		user.setUserName("sda");//hibernate会自动与数据库匹配（一级缓存），如果一样就更新数据库
		
		
		session.beginTransaction().commit();
		session.close();
		
		//关闭之后
		user.setUserName("Jack444444444");
		// 打印							【游离状态】
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
	}
}
