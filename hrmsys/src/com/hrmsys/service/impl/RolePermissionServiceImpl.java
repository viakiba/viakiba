package com.hrmsys.service.impl;

import java.util.List;

import com.hrmsys.dao.RolePermissionDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.Permission;
import com.hrmsys.model.Role;
import com.hrmsys.model.RolePermission;
import com.hrmsys.service.RolePermissionService;

public class RolePermissionServiceImpl implements RolePermissionService{
	private RolePermissionDAO rolePerDAO;

	@Override
	public String save(String checkedNodesIds) {
		boolean flag = true;
		String[] ids = checkedNodesIds.split(",");
		rolePerDAO.deleteByRole(ids[0]);
		for(int i = 1; i < ids.length; i++){
			RolePermission rp = new RolePermission();
			Role role = new Role();
			role.setRoleId(Integer.parseInt(ids[0].trim()));
			rp.setRole(role);
			Permission per = new Permission();
			per.setPerId(Integer.parseInt(ids[i].trim()));
			rp.setPermission(per);
			if(!rolePerDAO.saveOrUpdate(rp)){
				flag = false;
			}
		}
		if(flag) 
			return StaticValue.SAVE_SUCCESS;
		return StaticValue.SAVE_FAILURE;
	}
	
//	@Override
//	public String getPermission(int roleId, String perId) {
//		//将没有的权限组成json返回
//		StringBuffer sb = new StringBuffer("'");
//		if(rolePer.getRpAdd() == 0){
//			sb.append("add");
//		}
//		if(rolePer.getRpDelete() == 0){
//			sb.append(" delete");
//		}
//		if(rolePer.getRpQuery() == 0){
//			sb.append(" query");
//		}
//		if(rolePer.getRpUpdate() == 0){
//			sb.append(" update");
//		}
//		sb.append("'");
//		return sb.toString();
//	}
	public RolePermissionDAO getRolePerDAO() {
		return rolePerDAO;
	}

	public void setRolePerDAO(RolePermissionDAO rolePerDAO) {
		this.rolePerDAO = rolePerDAO;
	}
}
