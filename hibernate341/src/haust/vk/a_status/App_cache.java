package haust.vk.a_status;



import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App_cache {
	private static SessionFactory sf;
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(User.class)
				 .buildSessionFactory();
	}
	/*
	Session session = sf.openSession();
	session.beginTransaction();
	 
	session.getTransaction().commit();
	session.close();
	  
	 */
	
	@Test
	public void testCache() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		User user = null;
		//查询
		user = (User) session.get(User.class, 1);// 先检查缓存中是否有数据，如果有不查询数据库，直接从缓存中获取
		//session.evict(user);
		user = (User) session.get(User.class, 1);// 先检查缓存中是否有数据，如果有不查询数据库，直接从缓存中获取

		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testFlush() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		User user = null;
		user = (User) session.get(User.class, 1);
		user.setUserName("flush3");
		//缓存与数据同步
		session.flush();
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testClear() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		

		User user = null;
		user = (User) session.get(User.class, 1);
		
		// 清空缓存内容 
//		session.clear(); // 清空所有
		session.evict(user);// 清除指定
		
		user = (User) session.get(User.class, 5);
		
		session.getTransaction().commit();
		session.close();
	}
	
	//session 是否共享数据的判断    ---》不共享
	@Test
	public void testSession() throws Exception {
		Session session1 = sf.openSession();
		session1.beginTransaction();
		Session session2 = sf.openSession();
		session2.beginTransaction();
		
		// user放入session1的缓存区
		User user = (User) session1.get(User.class, 1);
		// user放入session2的缓存区
		session2.update(user);
				
		// 修改对象
		user.setUserName("New Name");  // 2条update
				
				
				
		session1.getTransaction().commit();  // session1.flush();
		session1.close();
		session2.getTransaction().commit();  // session2.flush();
		session2.close();
	}
}
