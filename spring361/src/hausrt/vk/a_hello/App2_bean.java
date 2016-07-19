package hausrt.vk.a_hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2_bean {
	/**
	 * 1) 对象创建： 单例/多例
	 * 	scope="singleton", 默认值， 即 默认是单例	【service/dao/工具类】
	 *  scope="prototype", 多例； 				【Action对象】
	 * 
	 * 
	 * 2) 什么时候创建?
	 * 	  scope="prototype"  在用到对象的时候，才创建对象。
	 *    scope="singleton"  在启动(容器初始化之前)， 就已经创建了bean，且整个应用只有一个。
	 * 3)是否延迟创建
	 * 	  lazy-init="false"  默认为false,  不延迟创建，即在启动时候就创建对象
	 * 	  lazy-init="true"   延迟初始化， 在用到对象的时候才创建对象
	 *    （只对单例有效）
	 * 4) 创建对象之后，初始化/销毁
	 * 	  init-method="init_user"       【对应对象的init_user方法，在对象创建爱之后执行 】
	 *    destroy-method="destroy_user"  【在调用容器对象的destriy方法时候执行，(容器用实现类)】
	 */
	@Test
	public void testIOC() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/hausrt/vk/a_hello/applicationContext.xml");
		System.out.println("----容器创建-----");
		
		// 从容器中获取bean
		User user =(User) ac.getBean("user");
		User user1 =(User) ac.getBean("user");
		
		System.out.println(user);
		System.out.println(user1);
		
		// 销毁容器对象 
		ac.destroy();
	}
	
	@Test
	public void testApp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/hausrt/vk/a_hello/applicationContext.xml");
		
		System.out.println("=====容器创建完成====");
		
		User user1=(User) ac.getBean("user1");
		
	}
}
