package com.hrmsys.bean;

import java.util.Date;

public class TrainRecordBean {
	private int tRecordId;
	private String empName;
	private String trainPerson;
	private String trainDate;
	private String trainTitle;
	private String trainPlace;
	private int trainResult;
	private String startDate;
	private String endDate;
	
	public int gettRecordId() {
		return tRecordId;
	}
	public void settRecordId(int tRecordId) {
		this.tRecordId = tRecordId;
	}
	public int getTrainResult() {
		return trainResult;
	}
	public void setTrainResult(int trainResult) {
		this.trainResult = trainResult;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTrainPerson() {
		return trainPerson;
	}
	public void setTrainPerson(String trainPerson) {
		this.trainPerson = trainPerson;
	}
	public String getTrainDate() {
		return trainDate;
	}
	public void setTrainDate(String trainDate) {
		this.trainDate = trainDate;
	}
	public String getTrainTitle() {
		return trainTitle;
	}
	public void setTrainTitle(String trainTitle) {
		this.trainTitle = trainTitle;
	}
	public String getTrainPlace() {
		return trainPlace;
	}
	public void setTrainPlace(String trainPlace) {
		this.trainPlace = trainPlace;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
