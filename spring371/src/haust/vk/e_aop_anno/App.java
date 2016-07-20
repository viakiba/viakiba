package haust.vk.e_aop_anno;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	ApplicationContext ac = new ClassPathXmlApplicationContext("haust/vk/e_aop_anno/bean.xml");
	
	// 目标对象有实现接口，spring会自动选择“JDK代理”
	@Test
	public void testApp() throws Exception {
		IUserDao userDao = (IUserDao) ac.getBean("userDao");
		System.out.println(userDao.getClass());//$Proxy001  
		userDao.save();
	}
	
	// 目标对象没有实现接口， spring会用“cglib代理”
	@Test
	public void testCglib() throws Exception {
		OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
		System.out.println(orderDao.getClass());
		orderDao.save();
	}
	
	@Deprecated
	// 共性问题：如果目标对象有实现接口，在从容器中获取目标对象的时候，只能通过接口接收对象。
	public void testApp2() {
		// 错误代码： 只能用接口接收
		UserDao userDao = (UserDao) ac.getBean("userDao");
		System.out.println(userDao.getClass());//$Proxy001  
		userDao.save();
	}
	
	@Test
	public void testGetObj() throws Exception {
		OrderDao orderDao1 = (OrderDao) ac.getBean("orderDao");
		OrderDao orderDao2 = (OrderDao) ac.getBean("orderDao");
		
		System.out.println(orderDao1);
		System.out.println(orderDao2);
		
	}
}
