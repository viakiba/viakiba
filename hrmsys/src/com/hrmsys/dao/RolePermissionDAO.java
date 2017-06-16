package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.model.RolePermission;

public interface RolePermissionDAO {
	/**
	 * 保存或修改
	 * @param rolePer
	 * @return
	 */
	boolean saveOrUpdate(RolePermission rolePer);
	/**
	 * 按roleId查询
	 * @param roleId
	 * @return
	 */
	List<RolePermission> findByRoleId(int roleId);
	/**
	 * 按权限和角色查询
	 * @param perId
	 * @param roleId
	 * @return
	 */
	RolePermission findByPerIdAndRoleId(int perId, String roleId);
	/**
	 * 按角色删除
	 * @param string
	 */
	void deleteByRole(String roleId);
}
