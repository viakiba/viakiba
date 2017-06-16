package com.hisoft.xypj.common.bean;

import java.util.Date;

public class CreditRating {

	private int classId;
	private String classification = null;
	private String symbol = null;
	private int scoringRangeS;
	private int scoringRangeE;
	private String credittips = null;
	private String interpretation = null;
	private int createUserId;
	private Date createTime = null;
	private Date updateTime = null;

	/**
	 * @return the classId
	 */
	public int getClassId() {
		return classId;
	}

	/**
	 * @param classId
	 *            the classId to set
	 */
	public void setClassId(int classId) {
		this.classId = classId;
	}

	/**
	 * @return the classification
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * @param classification
	 *            the classification to set
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the scoringRangeS
	 */
	public int getScoringRangeS() {
		return scoringRangeS;
	}

	/**
	 * @param scoringRangeS
	 *            the scoringRangeS to set
	 */
	public void setScoringRangeS(int scoringRangeS) {
		this.scoringRangeS = scoringRangeS;
	}

	/**
	 * @return the scoringRangeE
	 */
	public int getScoringRangeE() {
		return scoringRangeE;
	}

	/**
	 * @param scoringRangeE
	 *            the scoringRangeE to set
	 */
	public void setScoringRangeE(int scoringRangeE) {
		this.scoringRangeE = scoringRangeE;
	}

	/**
	 * @return the credittips
	 */
	public String getCredittips() {
		return credittips;
	}

	/**
	 * @param credittips
	 *            the credittips to set
	 */
	public void setCredittips(String credittips) {
		this.credittips = credittips;
	}

	/**
	 * @return the interpretation
	 */
	public String getInterpretation() {
		return interpretation;
	}

	/**
	 * @param interpretation
	 *            the interpretation to set
	 */
	public void setInterpretation(String interpretation) {
		this.interpretation = interpretation;
	}

	/**
	 * @return the createUserId
	 */
	public int getCreateUserId() {
		return createUserId;
	}

	/**
	 * @param createUserId
	 *            the createUserId to set
	 */
	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
