package haust.vk.d_component;

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
				 .addClass(Car.class)
				 .buildSessionFactory();
	}
	
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//创建对象
		Wheel wheel = new Wheel();
		wheel.setCount(86);
		wheel.setSize(10);
		
		Car car = new Car();
		car.setName("CarName");
		car.setWheel(wheel);
		
		//save
		session.save(car);
		
		
		session.beginTransaction().commit();
		session.close();
	}
}
