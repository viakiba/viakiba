package haust.vk.e_anno;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	ApplicationContext ac = new ClassPathXmlApplicationContext("haust/vk/e_anno/bean.xml");
	
	@Test
	public void testExecuteAction() throws Exception {
		//
		UserAction userAction = (UserAction) ac.getBean("userAction");
		userAction.execute();
	}
}
