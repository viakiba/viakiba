package com.hrmsys.model;

/**
 * RolePermission entity. @author MyEclipse Persistence Tools
 */

public class RolePermission implements java.io.Serializable {

	// Fields

	private Integer rpId;
	private Role role;
	private Permission permission;

	// Constructors

	/** default constructor */
	public RolePermission() {
	}

	/** full constructor */
	public RolePermission(Role role, Permission permission) {
		this.role = role;
		this.permission = permission;
	}

	// Property accessors

	public Integer getRpId() {
		return this.rpId;
	}

	public void setRpId(Integer rpId) {
		this.rpId = rpId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}