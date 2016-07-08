package haust.vk.b_one2Many;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;


public class testApp3_inverse {
	private static SessionFactory sf;
	
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(Dept.class)
				 .addClass(Employee.class)
				 .buildSessionFactory();
	}
	
	//保存数据
	 // inverse=true,  不会设置关联。
	//                 此时的关联应该通过员工方维护。

	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//部门对象
		Dept dept = new Dept();
		dept.setDeptName("dept_inverse");
		
		//员工对象
		Employee employee = new Employee();
		employee.setEmpName("emp_inverse");
		
		//创建关系  一对多
		employee.setDept(dept);
		
		//保存
		session.save(employee);
		session.save(dept);
		
		session.beginTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, 5);
		System.out.println(dept.getEmps());
		
		session.beginTransaction().commit();
		session.close();
	}
	
	/*3. 是否设置inverse，对解除关联关系影响？
	  inverse=false，  可以解除关联
	  inverse=true，  当前方(部门)没有控制权，不能解除关联关系(不会生成update语句,也不会报错)
	 */
	@Test
	public void testRemRea() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//获取部门
		Dept dept = (Dept) session.get(Dept.class, 5);
		dept.getEmps().clear();
		
		session.getTransaction().commit();
		session.close();
	}
	
	/*
	 3. 是否设置inverse属性，在删除数据中对关联关系的影响?
	     inverse=false, 有控制权， 可以删除。先清空外键引用，再删除数据。
		 inverse=true,  没有控制权: 如果删除的记录有被外键引用，会报错，违反主外键引用约束！
						 如果删除的记录没有被引用，可以直接删除。
	*/
	
	@Test
	public void testDel() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 查询部门
		Dept dept = (Dept) session.get(Dept.class, 6);
		session.delete(dept);
		session.beginTransaction().commit();
		session.close();
	}
}
