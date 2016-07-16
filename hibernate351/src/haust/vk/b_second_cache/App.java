package haust.vk.b_second_cache;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class App {
	private static SessionFactory sf;
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(Dept.class)
				 .addClass(Employee.class)
				 .buildSessionFactory();
	}
	
	//1.测试二级缓存使用
	// 没有/有用  二级缓存
	@Test
	public void testCriteria() throws Exception {
		Session session1 = sf.openSession();
		session1.beginTransaction();
		
		//查询一次
		Dept dept1 =(Dept) session1.get(Dept.class, 1);
		dept1.getEmps().size();// 集合
		
		session1.beginTransaction().commit();
		session1.close();
		
		System.out.println("----------");
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		
		//查询一次
		dept1 =(Dept) session2.get(Dept.class, 1);
		// 二级缓存配置好； 这里不查询数据库
		dept1.getEmps().size();
		
		session2.beginTransaction().commit();
		session2.close();
	}
	
	
	@Test
	public void testListCache() throws Exception {
		Session session1 = sf.openSession();
		session1.beginTransaction();
		
		//查询一次
		Query q = session1.createQuery("from Dept").setCacheable(true);// 【setCacheable  指定从二级缓存找，或者是放入二级缓存】
		System.out.println(q.list());
		
		session1.beginTransaction().commit();
		session1.close();
		
		System.out.println("----------");
		
		Session session2 = sf.openSession();
		session1.beginTransaction();
		
		//查询一次
		q = session1.createQuery("from Dept").setCacheable(true);
		System.out.println(q.list());// 不查询数据库： 需要开启查询缓存
		
		session2.beginTransaction().commit();
		session2.close();
	}
}
