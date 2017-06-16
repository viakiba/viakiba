package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.model.Role;

public interface RoleDAO {
	/**
	 * 查询全部
	 * @return
	 */
	List<Role> findAll();
	/**
	 * 保存
	 * @param role
	 */
	boolean save(Role role);
	/**
	 * 按id删除 
	 * @param id
	 */
	boolean deleteById(String id);
	/**
	 * 修改
	 * @param role
	 * @return
	 */
	boolean update(Role role);

}
