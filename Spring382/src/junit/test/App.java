package junit.test;

import static org.junit.Assert.*;
import haust.vk.entity.Dept;
import haust.vk.service.DeptService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
	@Test
	public void testApp() throws Exception {
		DeptService deptServie = (DeptService) ac.getBean("deptService");
		System.out.println(deptServie.getClass());
		
		deptServie.save(new Dept());
	}
}
