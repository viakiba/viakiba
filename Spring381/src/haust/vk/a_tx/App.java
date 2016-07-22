package haust.vk.a_tx;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	@Test
	public void testApp() throws Exception {
		ApplicationContext ac=new ClassPathXmlApplicationContext("haust/vk/a_tx/bean.xml");
		
		//模拟数据
		Dept dept= new Dept();
		dept.setDeptName("测试 ： 开发部");
		
		DeptService deptService = (DeptService) ac.getBean("deptService");
		deptService.save(dept);
	}
}
