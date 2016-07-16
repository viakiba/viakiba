package haust.vk.c_session;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class App {
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(haust.vk.b_second_cache.Dept.class)   
			.addClass(haust.vk.b_second_cache.Employee.class)   // 测试时候使用
			.buildSessionFactory();
	}
	
	@Test
	public void testSession() throws Exception {
		//openSession:  创建Session, 每次都会创建一个新的session
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		System.out.println(session1 == session2);
		session1.close();
		session2.close();
		
		//getCurrentSession 创建或者获取session
		// 线程的方式创建session  
		// 一定要配置：<property name="hibernate.current_session_context_class">thread</property>
		Session session3 = sf.getCurrentSession();// 创建session，绑定到线程
		Session session4 = sf.getCurrentSession();// 从当前访问线程获取session
		System.out.println(session3 == session4);
		
		// 关闭 【以线程方式创建的session，可以不用关闭； 线程结束session自动关闭】
		//session3.close();
		//session4.close(); 报错，因为同一个session已经关闭了！
	}
}
