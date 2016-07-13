package haust.vk.c_one2one2;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App {
	private static SessionFactory sf;
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(User.class)
				 .addClass(IdCard.class)
				 .buildSessionFactory();
	}
	
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//创建用户
		User user = new User();
		user.setUserName("jack1");
		
		//创建身份证对象
		IdCard idCard = new IdCard();
		idCard.setCardNum("564674646445");
		idCard.setPlace("hsah");
		idCard.setUser(user);
		
		//关系创建   级联是在 idCard 中
		idCard.setUser(user);
		
		session.save(idCard);
		
		
		session.beginTransaction().commit();
		session.close();
	}
}
