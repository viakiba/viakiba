package haust.vk.service;

import java.util.List;

import haust.vk.dao.AdminDao;
import haust.vk.entity.Admin;

/**
 * @author vk
 *
 * 2016年6月16日
 */
public class AdminService {
	private AdminDao dao=new AdminDao();
	
	public Admin login(Admin admin){
		try {
			System.out.println("执行servic方法");
			return dao.login(admin);
		} catch (Exception e) {
			System.out.println("dao异常");
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Admin> getAll(){
		try {
			return dao.getAll();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
}
