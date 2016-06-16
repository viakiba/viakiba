package haust.vk.a_generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vk
 *
 * 2016年5月11日
 */
public class App_super {
	/*
	 * super 限定元素范围 必须是String父类  【下限】
	 */
	void save(List<? super String> list){
		
	}
	
	public void testGeberic() throws Exception{
		
		List<Object> list1 = new ArrayList<Object>();
		List<String> list2 = new ArrayList<String>();
		
		List<Integer> list3 = new ArrayList<Integer>();
		
		save(list1);
		save(list2);
		//save(list3);
		
		
	}
}
