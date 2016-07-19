package hausrt.vk.a_hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App1_get_ioc {
	//1.通过工厂类得到IOC容器创建的对象
	@Test
	public void testIOC() throws Exception {
		//创建对象
		User user1 = new User();
		
		// 现在，把对象的创建交给spring的IOC容器
		Resource resource = new ClassPathResource("haust/vk/a_hello/applicationContext.xml");
		
		// 创建容器对象(Bean的工厂), IOC容器 = 工厂类 + applicationContext.xml
		BeanFactory factory = new XmlBeanFactory(resource);
		
		//
		User user =(User) factory.getBean("user");
		
		System.out.println(user.getId());
	}
	
	//（方便）直接得到IOC容器对象
	@Test
	public void testAc() throws Exception {
		//得到IOC容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("haust/vk/a_hello/applicationContext");
		
		//从容器中获取bean
		User user =(User) ac.getBean("user");
		System.out.println(user);
	}
}
