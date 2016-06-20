package haust.vk.d_compositeKey;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App {
	private static SessionFactory sf;
	
	static {
		//
		sf = new Configuration()
				 .configure()
				 .addClass(User.class)
				 .buildSessionFactory();
	}
	
	//保存对象
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		CompositeKeys keys = new CompositeKeys();
		keys.setAddress("河南");
		keys.setUserName("sas");
		
		User user=new User();
		user.setAge(11);
		user.setKeys(keys);
		
		session.save(user);
		
		tx.commit();
		session.close();
	}
	
	//
	@Test
	public void testGet() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		CompositeKeys keys = new CompositeKeys();
		keys.setAddress("河南");
		keys.setUserName("sas");
		
		
		
		//
		User user=(User)session.get(User.class,keys);
		if(user != null){
			System.out.println(user.getKeys().getUserName());
			System.out.println(user.getKeys().getAddress());
			System.out.println(user.getAge());
		}
		
		tx.commit();
		session.close();
		
	}
}
