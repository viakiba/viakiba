package haust.vk.service;

import haust.vk.entity.Admin;

/**
 * @author vk
 *
 * 2016年4月22日
 */
public interface IAdminService {
	Admin findByNameAndPwd(Admin admin);
}
