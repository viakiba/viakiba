package haust.vk.a_hello;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

/**
 * @author vk
 *
 * 2016年6月19日
 */
public class App3 {
	private static SessionFactory sf;
	
	static{
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	//hql查询 【是和有数据库基础的】
	@Test
	public void testQuery() throws Exception {
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		//主键查询
		Query q = session.createQuery("from Employee where empId=1 or empId=2");
		
		List<Employee> list = q.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	//QBC查询  , query by criteria  完全面向对象的查询
	@Test
	public void testQbc() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		//添加条件
		criteria.add(Restrictions.eq("empId", 1));
		//查询全部
		List list = criteria.list();
		//
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	//原生 sql 语句
	@Test
	public void testSql() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery sqlQuery = session.createSQLQuery("select * from employee").addEntity(Employee.class);
		List list = sqlQuery.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
}
