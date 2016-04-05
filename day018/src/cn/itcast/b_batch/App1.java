package cn.itcast.b_batch;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class App1 {
	
	@Test
	public void test1(){
		List<Admin> list=new ArrayList<Admin>();
		
		for(int i=0; i<21; i++){
			Admin admin=new Admin();
			admin.setName("vk"+i);
			admin.setPassword("1221"+i);
			list.add(admin);
		}
		
		AdminDao1 dao=new AdminDao1();
		
		dao.save(list);
	}
}
