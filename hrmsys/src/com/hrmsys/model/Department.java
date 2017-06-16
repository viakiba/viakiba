package com.hrmsys.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private String deptId;
	private String deptName;
	private String deptRemark;
	private String deptMgr; //部门经理
//	private Set employees = new HashSet(0);
//	private Set jobs = new HashSet(0);
	/**下面属性并不持久化到数据库中**/
	private Integer deptNum; //部门人数
	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String deptName, String deptId) {
		this.deptName = deptName;
		this.deptId = deptId;
	}

	/** full constructor */
	public Department(String deptName,String deptId, String deptRemark, String deptMgr) {
		this.deptName = deptName;
		this.deptId = deptId;
		this.deptRemark = deptRemark;
		this.deptMgr = deptMgr;
//		this.employees = employees;
//		this.jobs = jobs;
	}

	// Property accessors


	public String getDeptName() {
		return this.deptName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptRemark() {
		return this.deptRemark;
	}

	public void setDeptRemark(String deptRemark) {
		this.deptRemark = deptRemark;
	}

	public String getDeptMgr() {
		return deptMgr;
	}

	public void setDeptMgr(String deptMgr) {
		this.deptMgr = deptMgr;
	}

	public Integer getDeptNum() {
		return deptNum;
	}

	public void setDeptNum(Integer deptNum) {
		this.deptNum = deptNum;
	}

//	public Set getEmployees() {
//		return this.employees;
//	}
//
//	public void setEmployees(Set employees) {
//		this.employees = employees;
//	}
//
//	public Set getJobs() {
//		return this.jobs;
//	}
//
//	public void setJobs(Set jobs) {
//		this.jobs = jobs;
//	}

}