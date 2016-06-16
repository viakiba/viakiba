package haust.vk.a_generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author vk
 *
 *ctrl + shift + R 查看项目中的类
 *ctrl + shift + T 查看累的源码
 *ctrl + shift + L 快速获取方法返回值 
 *
 * 2016年5月11日
 */



/*
 * 泛型的关键字  ？  extends super
 */


/*
泛型中： 
?   			指定只是接收值
extends      元素的类型必须继承自指定的类
super        元素的类型必须是指定的类的父类
*/

public class App_extends {
	public void save(List<? extends Number> list) {
		// TODO Auto-generated method stub

	}
	
	@Test
	 //?  可以接收任何泛型集合， 但是不能编辑集合值； 所以一般在方法参数中用
	
	//Double Integer Float  String
	public void testGeneric() throws Exception{
		List<Double> list1 = new ArrayList<Double>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Float> list3 = new ArrayList<Float>();
		
		List<String> list4=new ArrayList<String>();
		
		//调用
		save(list1);
		save(list2);
		save(list3);
		
		//save(list4);
	}
}
