package haust.vk.a_generic;

import java.util.ArrayList;
import java.util.List;

import javax.xml.registry.infomodel.PersonName;

import org.junit.Test;

/**
 * @author vk
 *
 * 2016年5月11日
 */
public class App {
	
	//运行时期异常
	@Test
	public void testGeneric() throws Exception{
		List list=new ArrayList();
		list.add(1);
		list.add("china");
		
		String str=(String) list.get(1);//取第一个就挂了
		System.out.println(str);
	}
	
	//目标，把运行时期异常，尽量的转化成编译时期异常，这样才能先知先觉
	@Test
	public void testGeneric2() throws Exception{
		List<String> list=new ArrayList<String>();//后面的string指定元素类型，前面的接收使用
		list.add("china");//只能添加string类型
		//否则编译时期报错
		String str=list.get(0);
		System.out.println(str);
	}
	
	//泛型的擦除
	
/*	public void  save(List<Person> p){
		
	}
	public void save(List<Dept> d){
		
	}
	//Method save(List<Dept>) has the same erasure save(List<E>) as another method in type App
	
	//也就是说，这两个方法编译之后是一样的，所谓的擦除，就是编译后class文件不存在泛型信息 
	*/
	
	//泛型的书写
	@Test
	public void testGeneric3() throws Exception{
		
		//泛型不支持基本数据类型，支持引用数据类型包括包装类
		
		//List<int> list=new ArrayList<int>();
		List<Integer>  list=new ArrayList<Integer>();
		//注意：前后写一个 也行，写两个必须前后一致
		List<String> list1=new ArrayList();
		List list2=new ArrayList<String> ();
		
		List<Person> list3=new ArrayList<Person>();
		
	}
}
