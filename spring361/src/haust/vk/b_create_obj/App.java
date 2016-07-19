package haust.vk.b_create_obj;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	// 测试：对象创建
	@Test
	public void testIOC() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("haust/vk/b_create_obj/bean.xml");
		
		User user1=(User) ac.getBean("user");
		User user2 = (User) ac.getBean("user4");
		System.out.println(user1);
		System.out.println("====分隔符========");
		System.out.println(user2);
	}
	
	// 测试: 容器中对象的写法
	@Test
	public void testObj() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("haust/vk/b_create_obj/bean.xml");
		User user = (User) ac.getBean("first");
		System.out.println(user);
	}
	
}
