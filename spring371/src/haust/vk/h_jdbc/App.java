
package haust.vk.h_jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	// ÈÝÆ÷¶ÔÏó
	ApplicationContext ac = new ClassPathXmlApplicationContext("haust/vk/h_jdbc/bean.xml");
	
	@Test
	public void testApp() throws Exception {
		UserDao1 ud = (UserDao1) ac.getBean("userDao");
//		ud.save();
		System.out.println(ud.findById(1));
		System.out.println(ud.getAll());
	}
}
