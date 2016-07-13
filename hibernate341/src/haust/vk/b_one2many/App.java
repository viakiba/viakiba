package haust.vk.b_one2many;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
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
	
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dept dept = new Dept();
	/*	
	    get： 及时查询
		dept = (Dept) session.get(Dept.class, 9);
		System.out.println(dept.getDeptName());
		*/
		
		// load，默认懒加载， 及在使用数据的时候，才向数据库发送查询的sql语句！
		dept = (Dept)session.load(Dept.class, 9);
		// 方式1： 先使用一下数据
		//dept.getDeptName();
		// 方式2：强迫代理对象初始化
		Hibernate.initialize(dept);
		// 方式3：关闭懒加载
		
		
		session.beginTransaction().commit();
		session.close();
	}
	
	//1. 主键查询，及区别
		@Test
		public void set() {
			Session session = sf.openSession();
			session.beginTransaction();
			Dept dept = (Dept) session.get(Dept.class, 10);
			System.out.println(dept.getDeptName());
			System.out.println("------");
			System.out.println(dept.getEmps().isEmpty());  //  SQL
			
			session.getTransaction().commit();
			session.close();
			
		}
}
