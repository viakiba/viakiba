package haust.vk.c_property;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	//private ApplicationContext ac = new ClassPathXmlApplicationContext("haust/vk/c_property/bean.xml");
	private ApplicationContext ac = new ClassPathXmlApplicationContext("haust/vk/c_property/bean_p.xml");
	@Test
	public void testSet() throws Exception {
	//	User user = (User) ac.getBean("user1");
		User user = (User) ac.getBean("user");
		
		System.out.println(user);
	}
	
	@Test
	public void testExecuteAction(){
		UserAction userAction = (UserAction) ac.getBean("userAction2");
		userAction.execute();
	}
}
