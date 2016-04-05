package cn.itcast.c_auto;

import org.junit.Test;

public class App {
	
	@Test
	public void test1(){
		
		Dept d=new Dept();
		d.setId(1);
		d.setDeptName("应用开发部");
		
		Employee e=new Employee();
		
		e.setEmpId(1);
		e.setEmpName("wangba");
		e.setDept(d);
		
		Empdao dao=new Empdao();
		dao.save(e);
	}
}
