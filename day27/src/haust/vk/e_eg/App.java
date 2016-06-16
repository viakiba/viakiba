package haust.vk.e_eg;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author vk
 *
 * 2016年5月13日
 */
public class App {
	@Test
	public void testDao() throws Exception {
		AdminDao admindao=new AdminDao();
		
		Admin admin = admindao.findById(8);
		
		System.out.println(admin);
		
		System.out.println(admindao.getAll());
	}
}
