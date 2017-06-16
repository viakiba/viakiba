package com.hrmsys.service;

public interface RolePermissionService {
	/**
	 * 保存
	 * @param checkedNodesIds
	 * @return
	 */
	String save(String checkedNodesIds);
	/**
	 * 获得权限
	 * @param roleId
	 * @param perId
	 * @return
	 */
	//String getPermission(int roleId, String perId);

}
