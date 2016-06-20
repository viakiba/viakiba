package haust.vk.c_hbm_config;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * @author vk
 *
 * 2016年6月20日
 */
public class App {
	private static SessionFactory sf;
	
	static{
		sf = new Configuration()
			 .configure()
			 .addClass(Employee.class)
			 .buildSessionFactory();//会自动加载映射文件：Employee.hbm.xml
	}
	
	
	@Test
	public void testSave() throws Exception {
		
		Employee emp = new Employee();
		emp.setEmpName("黄鹏");
		emp.setWorkDate(new Date());
		emp.setDesc("测试描述");
		
		Session sessiom = sf.openSession();
		Transaction tx = sessiom.beginTransaction();
		sessiom.save(emp);
		
		tx.commit();
		sessiom.close();
	}
	
}
