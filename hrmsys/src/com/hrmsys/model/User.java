package com.hrmsys.model;

import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Role role;
	private Employee employee;
	private String userName;
	private String userPwd;
	private String userRemark;
	private Date userDate;
	private String userLastIp;
	private String userLastTime;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userPwd, Date userDate) {
		this.userPwd = userPwd;
		this.userDate = userDate;
	}

	/** full constructor */
	public User(Role role, Employee employee, String userName, String userPwd,
			String userRemark, Date userDate) {
		this.role = role;
		this.employee = employee;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userRemark = userRemark;
		this.userDate = userDate;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserRemark() {
		return this.userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public Date getUserDate() {
		return this.userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	public String getUserLastIp() {
		return userLastIp;
	}

	public void setUserLastIp(String userLastIp) {
		this.userLastIp = userLastIp;
	}

	public String getUserLastTime() {
		return userLastTime;
	}

	public void setUserLastTime(String userLastTime) {
		this.userLastTime = userLastTime;
	}
}