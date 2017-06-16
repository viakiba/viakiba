package com.hrmsys.model;

import java.util.Date;

/**
 * TrainRecord entity. @author MyEclipse Persistence Tools
 */

public class TrainRecord implements java.io.Serializable {

	// Fields

	private Integer trecordId;
	private Train train;
	private Employee employee;
	private Integer trecordResult;
	private String trecordRemark;
	private String trecordAddPerson;
	private Date trecordAddDate;

	// Constructors

	/** default constructor */
	public TrainRecord() {
	}

	/** full constructor */
	public TrainRecord(Train train, Employee employee, Integer trecordResult,
			String trecordRemark, String trecordAddPerson, Date trecordAddDate ) {
		this.train = train;
		this.employee = employee;
		this.trecordAddDate = trecordAddDate;
		this.trecordAddPerson = trecordAddPerson;
		this.trecordResult = trecordResult;
		this.trecordRemark = trecordRemark;
	}

	// Property accessors

	public Integer getTrecordId() {
		return this.trecordId;
	}

	public void setTrecordId(Integer trecordId) {
		this.trecordId = trecordId;
	}

	public Train getTrain() {
		return this.train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getTrecordResult() {
		return this.trecordResult;
	}

	public void setTrecordResult(Integer trecordResult) {
		this.trecordResult = trecordResult;
	}

	public String getTrecordRemark() {
		return this.trecordRemark;
	}

	public void setTrecordRemark(String trecordRemark) {
		this.trecordRemark = trecordRemark;
	}

	public String getTrecordAddPerson() {
		return trecordAddPerson;
	}

	public void setTrecordAddPerson(String trecordAddPerson) {
		this.trecordAddPerson = trecordAddPerson;
	}

	public Date getTrecordAddDate() {
		return trecordAddDate;
	}

	public void setTrecordAddDate(Date trecordAddDate) {
		this.trecordAddDate = trecordAddDate;
	}

}