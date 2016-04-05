package cn.itcast.b_batch;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class App {

	@Test
	public void test1(){
		List<Admin> list=new ArrayList<Admin>();
		
		for(int i=0;i<5;i++){
			Admin admin = new Admin();
			admin.setName("Jack" + i);
			admin.setPassword("888" + i);
			list.add(admin);
		}
		// ±£´æ
				
				Admindao.save(list);
	}
}
