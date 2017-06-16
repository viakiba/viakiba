package com.hrmsys.model;

import java.util.Date;

/**
 * EncouragePunish entity. @author MyEclipse Persistence Tools
 */

public class EncouragePunish implements java.io.Serializable {

	// Fields

	private Integer epId;
	private Employee employee;
	private Integer epType;
	private String epTopic;
	private Float epMoney;
	private String epOther;
	private Date epReleaseDate;
	private String epReleasePerson;
	private String epReason;
	private String epRemark;

	// Constructors

	/** default constructor */
	public EncouragePunish() {
	}

	/** full constructor */
	public EncouragePunish(Employee employee, Integer epType, String epTopic,
			Float epMoney, String epOther, Date epReleaseDate,
			String epReleasePerson, 
			String epReason, String epRemark) {
		this.employee = employee;
		this.epType = epType;
		this.epTopic = epTopic;
		this.epMoney = epMoney;
		this.epOther = epOther;
		this.epReleaseDate = epReleaseDate;
		this.epReleasePerson = epReleasePerson;
		this.epReason = epReason;
		this.epRemark = epRemark;
	}

	// Property accessors

	public Integer getEpId() {
		return this.epId;
	}

	public void setEpId(Integer epId) {
		this.epId = epId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getEpType() {
		return this.epType;
	}

	public void setEpType(Integer epType) {
		this.epType = epType;
	}

	public String getEpTopic() {
		return this.epTopic;
	}

	public void setEpTopic(String epTopic) {
		this.epTopic = epTopic;
	}

	public Float getEpMoney() {
		return this.epMoney;
	}

	public void setEpMoney(Float epMoney) {
		this.epMoney = epMoney;
	}

	public String getEpOther() {
		return this.epOther;
	}

	public void setEpOther(String epOther) {
		this.epOther = epOther;
	}

	public Date getEpReleaseDate() {
		return this.epReleaseDate;
	}

	public void setEpReleaseDate(Date epReleaseDate) {
		this.epReleaseDate = epReleaseDate;
	}

	public String getEpReleasePerson() {
		return this.epReleasePerson;
	}

	public void setEpReleasePerson(String epReleasePerson) {
		this.epReleasePerson = epReleasePerson;
	}

	public String getEpReason() {
		return this.epReason;
	}

	public void setEpReason(String epReason) {
		this.epReason = epReason;
	}

	public String getEpRemark() {
		return this.epRemark;
	}

	public void setEpRemark(String epRemark) {
		this.epRemark = epRemark;
	}

}