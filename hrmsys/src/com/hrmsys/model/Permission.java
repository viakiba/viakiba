package com.hrmsys.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Permission entity. @author MyEclipse Persistence Tools
 */

public class Permission implements java.io.Serializable {

	// Fields

	private Integer perId;
	private Menu menu;
	private Integer perFunction;
	private Set rolePermissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Permission() {
	}

	/** minimal constructor */
	public Permission(Menu menu, Integer perFunction) {
		this.menu = menu;
		this.perFunction = perFunction;
	}

	/** full constructor */
	public Permission(Menu menu, Integer perFunction, Set rolePermissions) {
		this.menu = menu;
		this.perFunction = perFunction;
		this.rolePermissions = rolePermissions;
	}

	// Property accessors

	public Integer getPerId() {
		return this.perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Integer getPerFunction() {
		return this.perFunction;
	}

	public void setPerFunction(Integer perFunction) {
		this.perFunction = perFunction;
	}

	public Set getRolePermissions() {
		return this.rolePermissions;
	}

	public void setRolePermissions(Set rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

}