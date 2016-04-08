package haust.vk.c_jdbc;

import java.util.List;

import org.junit.Test;


public class AdminDaoTest {
	
	@Test
	public void test1() throws Exception{
		AdminDao adminDao = new AdminDao();
		//adminDao.delete(2);
		//adminDao.save(new Admin());
		
		// ≤‚ ‘≤È—Ø
		List<Admin> list = adminDao.getAll();
		System.out.println(list);
	}
	
}
