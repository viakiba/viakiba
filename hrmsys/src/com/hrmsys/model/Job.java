package com.hrmsys.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Job entity. @author MyEclipse Persistence Tools
 */

public class Job implements java.io.Serializable {

	// Fields

	private Integer jobId;
	private Department department;
	private String jobName;
	private String jobRemark;
	private float jobBasicWage;
	// Constructors

	/** default constructor */
	public Job() {
	}

	/** minimal constructor */
	public Job(Integer jobId, String jobName) {
		this.jobId = jobId;
		this.jobName = jobName;
	}

	/** full constructor */
	public Job(Integer jobId, Department department, String jobName,
			String jobRemark, float jobBasicWage) {
		this.jobId = jobId;
		this.department = department;
		this.jobName = jobName;
		this.jobRemark = jobRemark;
		this.jobBasicWage = jobBasicWage;
	}

	// Property accessors

	public Integer getJobId() {
		return this.jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobRemark() {
		return this.jobRemark;
	}

	public void setJobRemark(String jobRemark) {
		this.jobRemark = jobRemark;
	}

	public float getJobBasicWage() {
		return jobBasicWage;
	}

	public void setJobBasicWage(float jobBasicWage) {
		this.jobBasicWage = jobBasicWage;
	}
	
}