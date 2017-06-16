package com.hrmsys.model;

import java.util.Date;

/**
 * Recruitment entity. @author MyEclipse Persistence Tools
 */

public class Recruitment implements java.io.Serializable {

	// Fields

	private Integer recId;
	private String recTitle;
	private String recContent;
	private Date recStart;
	private Date recEnd;
	private String recPerson;
	private Date recDate;
	private String recJob;
	private Integer recNum;
	private String recRemark;

	// Constructors

	/** default constructor */
	public Recruitment() {
	}

	/** minimal constructor */
	public Recruitment(Integer recId, String recTitle, String recContent,
			String recPerson, Date recDate, String recJob, Integer recNum) {
		this.recId = recId;
		this.recTitle = recTitle;
		this.recContent = recContent;
		this.recPerson = recPerson;
		this.recDate = recDate;
		this.recJob = recJob;
		this.recNum = recNum;
	}

	/** full constructor */
	public Recruitment(Integer recId, String recTitle, String recContent,
			Date recStart, Date recEnd, String recPerson, Date recDate,
			String recJob, Integer recNum, String recRemark) {
		this.recId = recId;
		this.recTitle = recTitle;
		this.recContent = recContent;
		this.recStart = recStart;
		this.recEnd = recEnd;
		this.recPerson = recPerson;
		this.recDate = recDate;
		this.recJob = recJob;
		this.recNum = recNum;
		this.recRemark = recRemark;
	}

	// Property accessors

	public Integer getRecId() {
		return this.recId;
	}

	public void setRecId(Integer recId) {
		this.recId = recId;
	}

	public String getRecTitle() {
		return this.recTitle;
	}

	public void setRecTitle(String recTitle) {
		this.recTitle = recTitle;
	}

	public String getRecContent() {
		return this.recContent;
	}

	public void setRecContent(String recContent) {
		this.recContent = recContent;
	}

	public Date getRecStart() {
		return this.recStart;
	}

	public void setRecStart(Date recStart) {
		this.recStart = recStart;
	}

	public Date getRecEnd() {
		return this.recEnd;
	}

	public void setRecEnd(Date recEnd) {
		this.recEnd = recEnd;
	}

	public String getRecPerson() {
		return this.recPerson;
	}

	public void setRecPerson(String recPerson) {
		this.recPerson = recPerson;
	}

	public Date getRecDate() {
		return this.recDate;
	}

	public void setRecDate(Date recDate) {
		this.recDate = recDate;
	}

	public String getRecJob() {
		return this.recJob;
	}

	public void setRecJob(String recJob) {
		this.recJob = recJob;
	}

	public Integer getRecNum() {
		return this.recNum;
	}

	public void setRecNum(Integer recNum) {
		this.recNum = recNum;
	}

	public String getRecRemark() {
		return this.recRemark;
	}

	public void setRecRemark(String recRemark) {
		this.recRemark = recRemark;
	}

}