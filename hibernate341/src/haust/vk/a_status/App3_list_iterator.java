package haust.vk.a_status;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App3_list_iterator {
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
		
		//获取对象
		User user =(User) session.get(User.class, 1);
		System.out.println(user.getUserId()+"--"+user.getUserName());
		
		session.beginTransaction().commit();
		session.close();
	 */
	/**
	 * list与iterator区别
	 * 1. list 方法
	 * 2. iterator 方法
	 * 3. 缓存
	 * @throws Exception
	 */
	@Test
	public void testList() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
			
		//获取对象
		Query q = session.createQuery("from User");
		List<User> list = q.list();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		session.beginTransaction().commit();
		session.close();
	}
	
	@Test
	public void testIterator() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("from User");
		Iterator it = q.iterate();
		while(it.hasNext()){
			User user =(User) it.next();
			System.out.println(user);
		}
		
		session.beginTransaction().commit();
		session.close();
	}
	
	@Test
	public void testCache() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("from User");
		/*List<User> it = q.list();
		
		for(int i=0;i<it.size();i++){
			System.out.println(it.get(i));
		}
		
		System.out.println("=========list===========");
		
		it = q.list();				// 【会放入?】  会但是不会读取
		
		for (int i=0; i<it.size(); i++){
			System.out.println(it.get(i));
		}
		System.out.println("------iterteor-------");*/
		Iterator<User> ite = q.iterate();
		while(ite.hasNext()){
			User user = ite.next();
			System.out.println(user);
		}
		System.out.println("分隔符");
		ite=q.iterate();//可以放入缓存 也可以读取
		while(ite.hasNext()){
			User user = ite.next();
			System.out.println(user);
		}
		
		session.beginTransaction().commit();
		session.close();
	}
	
	
	
}
