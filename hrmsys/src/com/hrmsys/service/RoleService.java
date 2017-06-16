package com.hrmsys.service;

import com.hrmsys.model.Role;

public interface RoleService {
	/**
	 * 查询全部,返回树形所需的json
	 * @return
	 */
	String list();
	/**
	 * 查询全部
	 * @return
	 */
	String getAll();
	/**
	 * 保存
	 * @param role
	 * @return
	 */
	String save(Role role);
	/**
	 * 按id删除
	 * @param id
	 * @return
	 */
	String deleteById(String id);
	/**
	 * 修改
	 * @param role
	 * @return
	 */
	String update(Role role);

}
