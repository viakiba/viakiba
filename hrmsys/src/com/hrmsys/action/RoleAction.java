package com.hrmsys.action;

import com.hrmsys.model.Role;
import com.hrmsys.service.RoleService;

public class RoleAction extends BaseAction{
	private RoleService roleService;
	private Role role;
	private String id;
	/**
	 * 树形列表
	 */
	public void list(){
		String roleJson = roleService.list();
		this.out(roleJson);
	}
	
	public void save(){
		String msg = null;
		if(null == role.getRoleId()){
			msg = roleService.save(role);
		}else{
			msg = roleService.update(role);
		}
		this.setRole(null);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void delete (){
		String msg = roleService.deleteById(id);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void listAll(){
		String roleJson = roleService.getAll();
		this.out(roleJson);
	}
	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
