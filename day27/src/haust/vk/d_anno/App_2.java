package haust.vk.d_anno;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

/**
 * @author vk
 *
 * 2016年5月13日
 */
public class App_2 {
	private String test;
	
	@Id
	@Author(remark = "保存联系人" , age=18 )
	public void save() throws Exception{
		//获取注解信息 ： name age remark
		
		//1.先获取方法的method类型
		Class clazz=App_2.class;
		Method m=clazz.getMethod("save");
		
		//2.再获取方法上的注解
		Author author=m.getAnnotation(Author.class);
		//获取输出注解信息
		System.out.println(author.authorName());
		System.out.println(author.remark());
		System.out.println(author.age());
				
		
	}
	
	@Test
	public void testMain() throws Exception {
		save();
	}
}
