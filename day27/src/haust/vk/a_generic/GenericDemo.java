package haust.vk.a_generic;

import org.junit.Test;

/**
 * @author vk
 *
 * 2016年5月11日
 */
public class GenericDemo<T> {
	//泛型方法 泛型接口
	
	//泛型方法
	public<K,A> T save(T t,K k,A a){   
		//前面的KA是指定数据类型  因为在类中声明了T 所以不再写T
		
		//T是指定返回的数据类型
		
		//K,A，T 是泛型的类型指定输入的类型
		
		//具体化实在方法使用时确定  第一次使用
		return null;
	}
	
	public void update(T t){// 解释同上
		
	}
	//
	
	@Test
	public void testMethod() throws Exception{
		GenericDemo<Integer> demo=new GenericDemo<Integer>();
		demo.save(1,"test",2);
	}
	
	
	
}
