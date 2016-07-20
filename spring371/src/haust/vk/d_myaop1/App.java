package haust.vk.d_myaop1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App {
	ApplicationContext ac=new ClassPathXmlApplicationContext("haust/vk/d_myaop1/bean.xml");
	@Test
	public void testMyaop() throws Exception {
		IUserDao dao= (IUserDao) ac.getBean("userDao_proxy");
		System.out.println(dao.getClass());
		dao.save();
	}

}