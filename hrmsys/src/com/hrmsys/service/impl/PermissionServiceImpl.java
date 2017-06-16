package com.hrmsys.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.hrmsys.bean.MenuBean;
import com.hrmsys.dao.MenuDAO;
import com.hrmsys.dao.PermissionDAO;
import com.hrmsys.dao.RolePermissionDAO;
import com.hrmsys.model.Menu;
import com.hrmsys.model.Permission;
import com.hrmsys.model.RolePermission;
import com.hrmsys.service.PermissionService;
import com.hrmsys.util.ConditionValidate;

public class PermissionServiceImpl implements PermissionService{
	private PermissionDAO permissionDAO;
	private MenuDAO menuDAO;
	private RolePermissionDAO rolePerDAO;
	
	@Override
	public synchronized String list(String id, String roleId) {
		List<Menu> menus = menuDAO.findNoeById(Integer.parseInt(id));
		List<MenuBean> menuBeans = new ArrayList<MenuBean>();
		for(Menu menu: menus){
			MenuBean menuBean = new MenuBean();
			menuBean.setId(menu.getMenuId());
			menuBean.setLeaf(menu.getMenuLeaf());
			menuBean.setMenuParentId(menu.getMenuParentId());
			menuBean.setMenuUrl(menu.getMenuUrl());
			menuBean.setText(menu.getMenuTitle());
			menuBean.setMenuIcon(menu.getMenuIcon());
			menuBean.setExpanded(true);
			//若为叶子结点查找其功能点
			//1查询  2添加 3修改 4删除 5详情 6保存或修改
			if(menu.getMenuLeaf() == 1){
				List<Permission> pers = permissionDAO.findByMnueId(menu.getMenuId());
				StringBuffer funcs = new StringBuffer("<table style='margin-left: 100px;'><tr>");
				int menuId = menu.getMenuId();
				for(Permission per : pers){
					int perId = per.getPerId();
					RolePermission rolePer = null;
					if(ConditionValidate.isEmpty(roleId)){
						rolePer = rolePerDAO.findByPerIdAndRoleId(perId, roleId);
					}
					switch(per.getPerFunction()){
					case 1:
						funcs.append("<td><input type='checkbox' name='"+menuId+"_rs' id='"+perId+"'");
						if(null != rolePer){
							funcs.append(" checked ");
						}
						funcs.append("/>查询&nbsp;&nbsp;</td>");break;
					case 2:
						funcs.append("<td><input type='checkbox' name='"+menuId+"_rs' id='"+perId+"'");
						if(null != rolePer){
							funcs.append(" checked ");
						}
						funcs.append("/>添加&nbsp;&nbsp;</td>");break;
					case 3:
						funcs.append("<td><input type='checkbox' name='"+menuId+"_rs' id='"+perId+"'");
						if(null != rolePer){
							funcs.append(" checked ");
						}
						funcs.append("/>修改&nbsp;&nbsp;</td>");break;
					case 4:
						funcs.append("<td><input type='checkbox' name='"+menuId+"_rs' id='"+perId+"'");
						if(null != rolePer){
							funcs.append(" checked ");
						}
						funcs.append("/>删除&nbsp;&nbsp;</td>");break;
					case 5:
						funcs.append("<td><input type='checkbox' name='"+menuId+"_rs' id='"+perId+"'");
						if(null != rolePer){
							funcs.append(" checked ");
						}
						funcs.append("/>详情&nbsp;&nbsp;</td>");break;
					case 6:
						funcs.append("<td><input type='checkbox' name='"+menuId+"_rs' id='"+perId+"'");
						if(null != rolePer){
							funcs.append(" checked ");
						}
						funcs.append("/>保存或修改&nbsp;&nbsp;</td>");break;
					}
				}
				funcs.append("</tr></table>");
				menuBean.setFunctions(funcs.toString());
			}
			menuBeans.add(menuBean);
		}
		return JSONArray.fromObject(menuBeans).toString();
	}
	
	@Override
	public String getPermission(int roleId, String menuId) {
		List<RolePermission> rolePers = rolePerDAO.findByRoleId(roleId);
		StringBuffer sb = new StringBuffer();
		for(RolePermission rolePer : rolePers){
			int perId = rolePer.getPermission().getPerId();
			Permission per = permissionDAO.findByPer(new Integer[]{perId, Integer.parseInt(menuId)});
			if(null!= per && per.getPerFunction() > 0){
				switch(per.getPerFunction()){
					case 1: sb.append(" query"); break;
					case 2: sb.append(" add"); break;
					case 3: sb.append(" update"); break;
					case 4: sb.append(" delete"); break;
					case 5: sb.append(" detail"); break;
					case 6: sb.append(" saveorupdate"); break;
				}
			}
		}
		return sb.toString().trim();
	}
	
	public PermissionDAO getPermissionDAO() {
		return permissionDAO;
	}

	public void setPermissionDAO(PermissionDAO permissionDAO) {
		this.permissionDAO = permissionDAO;
	}

	public MenuDAO getMenuDAO() {
		return menuDAO;
	}

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	public RolePermissionDAO getRolePerDAO() {
		return rolePerDAO;
	}

	public void setRolePerDAO(RolePermissionDAO rolePerDAO) {
		this.rolePerDAO = rolePerDAO;
	}
}
