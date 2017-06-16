package com.hrmsys.action;
/**
 * @author edwin
 * @time 2011-1-12
 */

import java.io.IOException;

import com.hrmsys.model.User;
import com.hrmsys.service.MenuService;

public class MenuAction extends BaseAction{
	private MenuService menuService;
	private String node;
	
	/**
	 * 依据传入的nodeId查找其子节点
	 * 之所有在这里没有利用struts-json.jar包，是因为能过此包传送过去的json为对象{},{},{}
	 * 而Ext所需的为数组，下面手动将list转化为一个json数组[{},{},{}]
	 * @throws IOException 
	 */
	public void load() throws IOException{
		String menuJson = null;
		User user = (User)this.getSession().get("user");
		if(node != null || !"".equals(node)){
			menuJson =  menuService.getNodeById(node, user);
		}
		this.out(menuJson);
	}
	
	/**follow is getter and setter**/
	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}
}
