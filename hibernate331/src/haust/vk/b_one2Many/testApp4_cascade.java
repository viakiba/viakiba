package haust.vk.b_one2Many;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;


public class testApp4_cascade {
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // 测试时候使用
			.buildSessionFactory();
	}
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 部门对象
		Dept dept = new Dept();
		dept.setDeptName("财务部");
		// 员工对象
		Employee emp_zs = new Employee();
		emp_zs.setEmpName("张三");
		Employee emp_ls = new Employee();
		emp_ls.setEmpName("李四");
		// 关系
		dept.getEmps().add(emp_zs);
		dept.getEmps().add(emp_ls); 
		
		session.save(dept);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testDel() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class,8);
		session.delete(dept); // 级联删除
		
		session.getTransaction().commit();
		session.close();
	}
}
