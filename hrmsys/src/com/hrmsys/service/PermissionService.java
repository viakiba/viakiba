package com.hrmsys.service;

public interface PermissionService {
	/**
	 * 查询清单
	 * @return
	 */
	String list(String id, String roleId);
	/**
	 * 按角色与菜单模块查询用户权限
	 * @param roleId
	 * @param menuId
	 * @return
	 */
	String getPermission(int roleId, String menuId);

}
