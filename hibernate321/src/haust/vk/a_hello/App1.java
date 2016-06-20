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
public class App1 {
	
	@Test
	public void testHello1() throws Exception {
		//实例化一个对象
		Employee emp = new Employee();
		emp.setEmpName("jackss");
		emp.setWorkDate(new Date());
		
		//获取加载的配置文件
		Configuration config = new Configuration();
		//加载默认位置的配置文件 src文件目录下
		config.configure();
		
		//创建一个session的工厂对象
		SessionFactory sf = config.buildSessionFactory();
		//创建session (代表一个绘画，与数据库链接的会话）
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		//执行保存到数据库的操作
		session.save(emp);
		//提交事务
		tx.commit();
		
		//关闭
		session.close();
		sf.close();
		
	}
}
