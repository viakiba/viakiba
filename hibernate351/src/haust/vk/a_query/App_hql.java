package haust.vk.a_query;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App_hql {
	private static SessionFactory sf;
	static{
		sf = new Configuration()
				 .configure()
				 .addClass(Dept.class)
				 .addClass(Employee.class)
				 .buildSessionFactory();
	}
	
	/*
	    1)	Get/load主键查询
		2)	对象导航查询
		3)	HQL查询，  Hibernate Query language  hibernate 提供的面向对象的查询语言。
		4)	Criteria 查询，   完全面向对象的查询（Query By Criteria  ,QBC）
		5)	SQLQuery， 本地SQL查询
	 */
	
	//1.主键查询
	@Test
	public void testOne() throws Exception {
		Session session = sf.openSession();
		
		
		session.beginTransaction();
		//1)	Get/load主键查询
		//1.主键查询
//		Dept dept = (Dept) session.get(Dept.class, 1);
//		System.out.println(dept);
		//2)	对象导航查询
		//2.对象导航查询
//		Dept dept = (Dept) session.get(Dept.class, 1);
//		System.out.println(dept.getDeptName());
//		System.out.println(dept.getEmps().toArray().length);
		
		//3)	HQL查询，  Hibernate Query language  hibernate 提供的面向对象的查询语言。
		//3.HQL查询
		// 注意：使用hql查询的时候 auto-import="true" 要设置true，
		//  如果是false，写hql的时候，要指定类的全名
		
		//a.查询全部列
//		Query q = session.createQuery("from Dept");
//		Query q = session.createQuery("select * from Dept");//错误语法，不支持*
//		Query q = session.createQuery("select d from Dept d");
//		System.out.println(q.list());
		
		//b.查询指定列 （返回对象数据 object）
//		Query q = session.createQuery("select d.deptId,d.deptName from Dept d ");
//		System.out.println(q.list());
		
		//c.查询指定列，自动封装为对象（必须要提供带参数的构造器）
//		Query q = session.createQuery("select new Dept(d.deptId,d.deptName) from Dept d ");
//		System.out.println(q.list());
		
		// d. 条件查询: 一个条件/多个条件and or/between and/模糊查询
		 
		// 条件查询： 占位符
//		Query q = session.createQuery("from Dept d where deptName=?");
//		q.setString(0, "dept1");
//		q.setParameter(0, "dept2");
//		System.out.println(q.list());
		
		// 条件查询： 命名参数
//		Query q = session.createQuery("from Dept d where deptId=:myId or deptName=:name");
//		q.setParameter("myId", 1);
//		q.setParameter("name", "dept1");
//		System.out.println(q.list());
		
		// 范围
//		Query q = session.createQuery("from Dept d where deptId between ? and ?");
//		q.setParameter(0, 1);
//		q.setParameter(1, 2);
//		System.out.println(q.list());
		
		// 模糊
//		Query q = session.createQuery("from Dept d where deptName like ?");
//		q.setParameter(0, "%d%");
//		System.out.println(q.list());
		
		// e. 聚合函数统计
//		Query q = session.createQuery("select count(*) from Dept d");
//		Object num = q.uniqueResult();
//		System.out.println((Long) num);
		
		// f. 分组查询
		//-- 统计t_employee表中，每个部门的人数
		//数据库写法：SELECT dept_id,COUNT(*) FROM t_employee GROUP BY dept_id;
		// HQL写法
//		Query q = session.createQuery("select e.dept , count(*) from Employee e group by e.dept");
//		System.out.println(q.list());
		
		session.beginTransaction().commit();
		session.close();
	}
	
	//连接查询
	//与映射文件有关
	
	@Test
	public void testJoin() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//1) 内连接   【映射已经配置好了关系，关联的时候，直接写对象的属性即可】
//		Query q=session.createQuery("from Dept d inner join d.emps");
//	    System.out.println(q.list());
	    
		//2)左外连接
//		Query q = session.createQuery("from Dept d left join d.emps");
//		System.out.println(q.list());
		
		//3）右外连接
//		Query q = session.createQuery("select new Employee(e.empName) from Employee e right join e.dept");
//		System.out.println(q.list());
		session.beginTransaction().commit();
		session.close();
	}
	
	// g. 连接查询 - 迫切连接
	@Test
	public void testFetch() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		//1) 迫切内连接    【使用fetch, 会把右表的数据，填充到左表对象中！】
//		Query q = session.createQuery("from Dept d inner join fetch d.emps");
//		System.out.println(q.list());
		
		//2) 迫切左外连接
    	Query q = session.createQuery("from Dept d inner join fetch d.emps");
    	System.out.println(q.list());
    	
    	/*
    	select
	        dept0_.deptId as deptId0_0_,
	        emps1_.empId as empId1_1_,
	        dept0_.deptName as deptName0_0_,
	        emps1_.empName as empName1_1_,
	        emps1_.salary as salary1_1_,
	        emps1_.dept_id as dept4_1_1_,
	        emps1_.dept_id as dept4_0_0__,
	        emps1_.empId as empId0__ 
    	from
        	t_dept dept0_ 
    	inner join
	        t_employee emps1_ 
	            on dept0_.deptId=emps1_.dept_id
    	 */
    	
		session.beginTransaction().commit();
		session.close();
	}

	//hql 查询优化
	public void bakSession() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//hql 写死
//		Query q = session.createQuery("from Dept d where deptId < 10 ");
//		System.out.println(q.list());
		
		//hql 放到映射文件中
		Query q = session.getNamedQuery("getAllDept");
		System.out.println(q.list());
		/*
		select
	        dept0_.deptId as deptId0_0_,
	        emps1_.empId as empId1_1_,
	        dept0_.deptName as deptName0_0_,
	        emps1_.empName as empName1_1_,
	        emps1_.salary as salary1_1_,
	        emps1_.dept_id as dept4_1_1_,
	        emps1_.dept_id as dept4_0_0__,
	        emps1_.empId as empId0__ 
    	from
        	t_dept dept0_ 
    	inner join
	        t_employee emps1_ 
	            on dept0_.deptId=emps1_.dept_id
		 */
		session.beginTransaction().commit();
		session.close();
	}

	
	
	
	
	
/*	
	
	//创建数据
	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//创建对象
		Dept dept = new Dept();
		dept.setDeptName("dept1");
		
		Dept dept2 = new Dept();
		dept2.setDeptName("dept1");
		
		Employee emp = new Employee();
		emp.setEmpName("emp1");
		emp.setSalary(20.0);
		emp.setDept(dept);
		
		Employee emp1 = new Employee();
		emp1.setEmpName("emp1");
		emp1.setSalary(20.0);
		emp1.setDept(dept);
		
		Employee emp2 = new Employee();
		emp2.setEmpName("emp1");
		emp2.setSalary(20.0);
		emp2.setDept(dept2);
		
		session.save(emp);
		session.save(emp1);
		session.save(emp2);
		
		session.beginTransaction().commit();
		session.close();
	}
*/
}
