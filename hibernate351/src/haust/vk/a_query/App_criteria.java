package haust.vk.a_query;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class App_criteria {
	private static SessionFactory sf;
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(Dept.class)
				 .addClass(Employee.class)
				 .buildSessionFactory();
	}
	//4)	Criteria 查询，   完全面向对象的查询（Query By Criteria  ,QBC）
	@Test
	public void testCriteria() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
//		Criteria cri = session.createCriteria(Employee.class);
		//
//		cri.add(Restrictions.eq("empId", 1));
//		cri.add(Restrictions.idEq(1));
		
//		Employee emp =(Employee) cri.list().get(0);
//		System.out.println(emp.getEmpName());
		
		session.beginTransaction().commit();
		session.close();
	}
	
	// 5)	SQLQuery， 本地SQL查询
	// 不能跨数据库平台： 如果该了数据库，sql语句有肯能要改。
	@Test
	public void testSql() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		SQLQuery q = session.createSQLQuery("select * from t_dept where deptId=1").addEntity(Dept.class);
		System.out.println(( (Dept) q.list().get(0)).getDeptName());
		session.beginTransaction().commit();
		session.close();
	}
}
