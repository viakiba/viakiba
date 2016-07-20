package haust.vk.g_point;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	ApplicationContext ac = 
			new ClassPathXmlApplicationContext("haust/vk/f_aop_xml/bean.xml");

		// 目标对象有实现接口，spring会自动选择“JDK代理”
		@Test
		public void testApp() {
			IUserDao userDao = (IUserDao) ac.getBean("userDao");
			System.out.println(userDao.getClass());//$Proxy001  
			
			userDao.save();
		}
		
		// 目标对象没有实现接口， spring会用“cglib代理”
		@Test
		public void testCglib() {
			OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
			System.out.println(orderDao.getClass());
			orderDao.save();
		}
}
