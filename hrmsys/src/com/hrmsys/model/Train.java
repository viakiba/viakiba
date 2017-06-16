package com.hrmsys.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Train entity. @author MyEclipse Persistence Tools
 */

public class Train implements java.io.Serializable {

	// Fields

	private Integer trainId;
	private String trainTitle;
	private String trainContent;
	private Date trainDate;
	private String trainPlace;
	private String trainPerson;
	private Date trainAddDate;
	private String trainRemark;
	private String trainAddPerson;
	private Set trainRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Train() {
	}

	/** minimal constructor */
	public Train(String trainTitle, String trainContent, Date trainDate,
			String trainPlace, String trainPerson, Date trainAddDate, String trainAddPerson) {
		this.trainTitle = trainTitle;
		this.trainContent = trainContent;
		this.trainDate = trainDate;
		this.trainPlace = trainPlace;
		this.trainPerson = trainPerson;
		this.trainAddDate = trainAddDate;
		this.trainAddPerson = trainAddPerson;
	}

	/** full constructor */
	public Train(String trainTitle, String trainContent, Date trainDate,
			String trainPlace, String trainPerson,String trainAddPerson, Date trainAddDate,
			String trainRemark, Set trainRecords) {
		this.trainTitle = trainTitle;
		this.trainContent = trainContent;
		this.trainDate = trainDate;
		this.trainPlace = trainPlace;
		this.trainPerson = trainPerson;
		this.trainAddDate = trainAddDate;
		this.trainRemark = trainRemark;
		this.trainRecords = trainRecords;
		this.trainAddPerson = trainAddPerson;
	}

	// Property accessors

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public String getTrainTitle() {
		return this.trainTitle;
	}

	public void setTrainTitle(String trainTitle) {
		this.trainTitle = trainTitle;
	}

	public String getTrainContent() {
		return this.trainContent;
	}

	public void setTrainContent(String trainContent) {
		this.trainContent = trainContent;
	}

	public Date getTrainDate() {
		return this.trainDate;
	}

	public void setTrainDate(Date trainDate) {
		this.trainDate = trainDate;
	}

	public String getTrainPlace() {
		return this.trainPlace;
	}

	public void setTrainPlace(String trainPlace) {
		this.trainPlace = trainPlace;
	}

	public String getTrainPerson() {
		return this.trainPerson;
	}

	public void setTrainPerson(String trainPerson) {
		this.trainPerson = trainPerson;
	}


	public String getTrainRemark() {
		return this.trainRemark;
	}

	public void setTrainRemark(String trainRemark) {
		this.trainRemark = trainRemark;
	}

	public Set getTrainRecords() {
		return this.trainRecords;
	}

	public void setTrainRecords(Set trainRecords) {
		this.trainRecords = trainRecords;
	}

	public Date getTrainAddDate() {
		return trainAddDate;
	}

	public void setTrainAddDate(Date trainAddDate) {
		this.trainAddDate = trainAddDate;
	}

	public String getTrainAddPerson() {
		return trainAddPerson;
	}

	public void setTrainAddPerson(String trainAddPerson) {
		this.trainAddPerson = trainAddPerson;
	}

}