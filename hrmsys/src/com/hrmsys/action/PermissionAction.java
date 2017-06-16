package com.hrmsys.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hrmsys.model.Menu;
import com.hrmsys.model.User;
import com.hrmsys.service.MenuService;
import com.hrmsys.service.PermissionService;

public class PermissionAction extends BaseAction{
	private PermissionService permissionService;
	private MenuService menuService;
	private String node;//树形传入的id
	private String menuId;
	private String roleId;

	public void list(){
		String permissionJson = permissionService.list(node, roleId);
		this.setRoleId(null);
		this.out(permissionJson);
	}
	
	public void permission(){
		Map permission = (Map)this.getSession().get("permission");
		String per = (String) permission.get(Integer.parseInt(menuId));
		//String per = permissionService.getPermission(roleId, menuId);
		this.out(per);
	}
	
	public void initPermission(){
		List<Menu> menus = menuService.getAllLeaf();
		User user = (User)this.getSession().get("user");
		int roleId = user.getRole().getRoleId();
		Map map = new HashMap();
		for(Menu menu : menus){
			int menuId = menu.getMenuId();
			String permission = permissionService.getPermission(roleId, String.valueOf(menuId));
			map.put(menuId, permission);
		}
		this.getSession().put("permission", map);
		this.out("{success: true}");
	}
	
	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
}
