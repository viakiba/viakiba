package haust.vk.b_reflect;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author vk
 *
 * 2016年5月11日
 */
public class App {
	@Test
	public void testSave() throws Exception {
		AdminDao adminDao=new AdminDao();
		Admin admin=adminDao.findById(1);
		
		System.out.println(admin);
		System.out.println(adminDao.getAll());
	}
	
	
	
}
