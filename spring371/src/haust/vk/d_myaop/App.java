package haust.vk.d_myaop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App {
	ApplicationContext ac=new ClassPathXmlApplicationContext("haust/vk/d_myaop/bean.xml");
	@Test
	public void testMyaop() throws Exception {
		IUserDao dao= (IUserDao) ac.getBean("userDao");
		dao.save();
	}

}