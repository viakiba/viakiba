package haust.vk.e_extends4;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;



public class App {
	private static SessionFactory sf;
	static{
		sf=new Configuration()
				.configure()
				.addClass(Animal.class)
				.buildSessionFactory();
	}
	
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 保存
		Cat cat = new Cat();
		cat.setName("大花猫");
		cat.setEatMouse("抓小老鼠");
		
		Monkey m = new Monkey();
		m.setName("猴子");
		m.setEatBanana("吃10个香蕉");
		
		session.save(cat);
		session.save(m);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
