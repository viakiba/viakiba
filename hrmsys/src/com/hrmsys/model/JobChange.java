package com.hrmsys.model;

import java.util.Date;

/**
 * JobChange entity. @author MyEclipse Persistence Tools
 */

public class JobChange implements java.io.Serializable {

	// Fields

	private Integer jcId;
	private Department departmentByJcNewDept;
	private Department departmentByJcOldDept;
	private Job jobByJcNewJob;
	private Job jobByJcOldJob;
	private Employee employee;
	private String jcAddPerson;
	private Date jcDate;
	private String jcReason;
	private String jcRemark;

	// Constructors

	/** default constructor */
	public JobChange() {
	}

	/** full constructor */
	public JobChange(Department departmentByJcNewDept,
			Department departmentByJcOldDept, Job jobByJcNewJob,
			Job jobByJcOldJob, Employee employee, String jcAddPerson,
			Date jcDate,  String jcReason, String jcRemark) {
		this.departmentByJcNewDept = departmentByJcNewDept;
		this.departmentByJcOldDept = departmentByJcOldDept;
		this.jobByJcNewJob = jobByJcNewJob;
		this.jobByJcOldJob = jobByJcOldJob;
		this.employee = employee;
		this.jcAddPerson = jcAddPerson;
		this.jcDate = jcDate;
		this.jcReason = jcReason;
		this.jcRemark = jcRemark;
	}

	// Property accessors

	public Integer getJcId() {
		return this.jcId;
	}

	public void setJcId(Integer jcId) {
		this.jcId = jcId;
	}

	public Department getDepartmentByJcNewDept() {
		return this.departmentByJcNewDept;
	}

	public void setDepartmentByJcNewDept(Department departmentByJcNewDept) {
		this.departmentByJcNewDept = departmentByJcNewDept;
	}

	public Department getDepartmentByJcOldDept() {
		return this.departmentByJcOldDept;
	}

	public void setDepartmentByJcOldDept(Department departmentByJcOldDept) {
		this.departmentByJcOldDept = departmentByJcOldDept;
	}

	public Job getJobByJcNewJob() {
		return this.jobByJcNewJob;
	}

	public void setJobByJcNewJob(Job jobByJcNewJob) {
		this.jobByJcNewJob = jobByJcNewJob;
	}

	public Job getJobByJcOldJob() {
		return this.jobByJcOldJob;
	}

	public void setJobByJcOldJob(Job jobByJcOldJob) {
		this.jobByJcOldJob = jobByJcOldJob;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getJcAddPerson() {
		return this.jcAddPerson;
	}

	public void setJcAddPerson(String jcAddPerson) {
		this.jcAddPerson = jcAddPerson;
	}

	public Date getJcDate() {
		return this.jcDate;
	}

	public void setJcDate(Date jcDate) {
		this.jcDate = jcDate;
	}


	public String getJcReason() {
		return this.jcReason;
	}

	public void setJcReason(String jcReason) {
		this.jcReason = jcReason;
	}

	public String getJcRemark() {
		return this.jcRemark;
	}

	public void setJcRemark(String jcRemark) {
		this.jcRemark = jcRemark;
	}

}