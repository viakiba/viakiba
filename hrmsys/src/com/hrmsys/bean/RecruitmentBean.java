package com.hrmsys.bean;

import java.util.Date;

public class RecruitmentBean {
	private String recTitle;
	private String recJob;
	private String startDate; //查询时间段时的开始时间
	private String endDate; //查询时间段时的结束时间
	
	public String getRecTitle() {
		return recTitle;
	}
	public void setRecTitle(String recTitle) {
		this.recTitle = recTitle;
	}
	public String getRecJob() {
		return recJob;
	}
	public void setRecJob(String recJob) {
		this.recJob = recJob;
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
