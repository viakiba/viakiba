package haust.vk.a_hello;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

/**
 * @author vk
 *
 * 2016年6月19日
 */
public class App2 {
	private static SessionFactory sf;
	static{
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	//保存对象
	@Test
	public void testSave() throws Exception {
		//对象
		Employee emp= new Employee();
		emp.setEmpName("dasda");
		emp.setWorkDate(new Date());
		
		//执行save的准备工作
		//获取session 即一个数据库的连接
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		//执行保存操作
		session.save(emp);
		//提交事务
		tx.commit();
		//关闭连接
		session.close();
	}
	
	//更新对象
	@Test
	public void testUppdate() throws Exception {
		//对象
		Employee emp= new Employee();
		emp.setEmpId(1);
		emp.setEmpName("sasaaaaaaaaaaa");
		emp.setWorkDate(new Date());
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.update(emp);
		
		tx.commit();
		
		session.close();
	}
}
