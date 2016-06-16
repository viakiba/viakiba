package haust.vk.c_reflect;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * @author vk
 *
 * 2016年5月12日
 */
public class App {
	//1.创建对象
	@Test
	public void testInfo() throws Exception {
		String className="haust.vk.c_reflect.Admin";
		//得到字节码
		Class<?> clazz=Class.forName(className);
		
		//创建对象1：默认构造函数简写
		Admin admin1 = (Admin) clazz.newInstance();
		
		//创建对象2：通过带参数 的构造器创建对象
		Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
		
		Admin admin =(Admin) constructor.newInstance("jack");
	}
	
	//2.获取属性的名称.值
	@Test
	public void testField() throws Exception {
		//类全名
		String className="haust.vk.c_reflect.Admin";
		//得到类的字节码
		Class<?> clazz = Class.forName(className);
		//对象
		Admin admin =(Admin) clazz.newInstance();
		
		//获取所有的属性名称
		Field[] fs = clazz.getDeclaredFields();
		
		//便利输出每一个属性的名称 。 值
		for(Field f : fs){
			//设置强制访问
			f.setAccessible(true);
			//名称
			String name = f.getName();
			//值
			Object value = f.get(admin);
			
			System.out.println(name+"<--->"+value);
		}
	}
	
	
	
	//3.反射获取方法
	@Test
	public void testMethod() throws Exception {
		//类全名
		String className="haust.vk.c_reflect.Admin";
		//得到类的字节码
		Class<?> clazz=Class.forName(className);
		//对象
		Admin admin=(Admin) clazz.newInstance();
		//获取Admin类中的方法对象 public int getId()
		Method m = clazz.getDeclaredMethod("getId");
		//调用方法
		Object r_value = m.invoke(admin);
		
		System.out.println(r_value);
		
	}
}
