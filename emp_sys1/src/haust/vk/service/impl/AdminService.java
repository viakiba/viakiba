package haust.vk.service.impl;

import haust.vk.dao.IAdminDao;
import haust.vk.dao.impl.AdminDao;
import haust.vk.entity.Admin;
import haust.vk.service.IAdminService;

/**
 * @author vk
 *
 * 2016年4月22日
 */
public class AdminService implements IAdminService {
	private IAdminDao a=new AdminDao();
	public Admin findByNameAndPwd(Admin admin) {
		try {
			return a.findByNameAndPwd(admin);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
