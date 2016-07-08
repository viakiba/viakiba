package haust.vk.a_collection;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class userTest {
	private static SessionFactory sf;
	
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(User.class)
				 .buildSessionFactory();
	}
	
	@Test
	public void testSet() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Set<String> addressSet = new HashSet<String>();
		addressSet.add("set地址1");
		addressSet.add("set地址2");
		
		
		//创建对象
		User user = new User();
		user.setUserName("setName");
		user.setAddressSet(addressSet);
		
		//保存
		session.save(user);
		
		session.beginTransaction().commit();
		
		session.close();
		
	}
	
	@Test
	public void testList() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//创建对象
		User user = new User();
		user.setUserName("ListName");
		
		user.getAddressList().add("LsitAddress1");
		user.getAddressList().add("ListAddress2");
		
		session.save(user);
		tx.commit();
		
		session.close();
		
	}
	
	@Test
	public void testMap() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//创建对象
		User user = new User();
		user.setUserName("UserNameMap");
		
		user.getAddressMap().put("short1", "MapName1");
		user.getAddressMap().put("short2", "MapName2");
		
		//
		session.save(user);
		session.beginTransaction().commit();
		
		session.close();
		
	}
	
	//获取
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User user =(User) session.get(User.class, 1);
		System.out.println(user.getUserId());
		System.out.println(user.getAddressSet());
		tx.commit();
		session.close();
		
	}
	
}
