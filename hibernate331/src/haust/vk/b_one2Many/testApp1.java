package haust.vk.b_one2Many;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;


public class testApp1 {
	private static SessionFactory sf ;
	
	static{
		sf=new Configuration()
			   .configure()
			   .addClass(Dept.class)
			   .addClass(Employee.class)
			   .buildSessionFactory();
	}
	
	
	//保存 部门方   一对一的方式
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//创建对象
		//部门
		Dept dept = new Dept();
		dept.setDeptName("Dept1");
		//职员
		Employee empz = new Employee();
		empz.setEmpName("zEmp");
		
		Employee empl = new Employee();
		empl.setEmpName("lEmp");
		
		//关系建立
		dept.getEmps().add(empl);
		dept.getEmps().add(empz);
		
		//保存
		session.save(empl);
		session.save(dept);
		session.save(empz);
		
		tx.commit();
		session.close();
		
		/**
			Hibernate: insert into t_employee (salary, empName, dept_id) values (?, ?, ?)
			Hibernate: insert into t_dept (deptName) values (?)
			Hibernate: insert into t_employee (salary, empName, dept_id) values (?, ?, ?)
			Hibernate: update t_employee set dept_id=? where empId=?
			Hibernate: update t_employee set dept_id=? where empId=?
		 */
	}
	
	// 保存 员工方  多对一  推荐
	@Test
	public void testSave2() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//创建对象
		Dept dept = new Dept();
		dept.setDeptName("dept2");
		
		//创建
		Employee emp_zs = new Employee();
		emp_zs.setEmpName("张三");
		Employee emp_ls = new Employee();
		emp_ls.setEmpName("李四");
		// 关系
		emp_ls.setDept(dept);
		emp_zs.setDept(dept);
		
		session.save(dept);
		session.save(emp_ls);
		session.save(emp_zs);
		
		tx.commit();
		session.close();
		
		/*
			Hibernate: insert into t_dept (deptName) values (?)
			Hibernate: insert into t_employee (salary, empName, dept_id) values (?, ?, ?)
			Hibernate: insert into t_employee (salary, empName, dept_id) values (?, ?, ?)
		*/
	}
}
