package haust.vk.d_auto;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("haust/vk/d_auto/bean.xml");
	
	@Test
	public void testExecuteAction() throws Exception {
		UserAction userAction = (UserAction) ac.getBean("userAction");
		userAction.execute();
	}
}
