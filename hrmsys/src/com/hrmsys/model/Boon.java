package com.hrmsys.model;

/**
 * Boon entity. @author MyEclipse Persistence Tools
 */

public class Boon implements java.io.Serializable {

	// Fields

	private Integer boonId;
	private String boonName;
	private Float boonMoney;
	private Float boonPercent;
	private String boonRemark;

	// Constructors

	/** default constructor */
	public Boon() {
	}

	/** minimal constructor */
	public Boon(Integer boonId) {
		this.boonId = boonId;
	}

	/** full constructor */
	public Boon(Integer boonId, String boonName, Float boonMoney,
			Float boonPercent, String boonRemark) {
		this.boonId = boonId;
		this.boonName = boonName;
		this.boonMoney = boonMoney;
		this.boonPercent = boonPercent;
		this.boonRemark = boonRemark;
	}

	// Property accessors

	public Integer getBoonId() {
		return this.boonId;
	}

	public void setBoonId(Integer boonId) {
		this.boonId = boonId;
	}

	public String getBoonName() {
		return this.boonName;
	}

	public void setBoonName(String boonName) {
		this.boonName = boonName;
	}

	public Float getBoonMoney() {
		return this.boonMoney;
	}

	public void setBoonMoney(Float boonMoney) {
		this.boonMoney = boonMoney;
	}

	public Float getBoonPercent() {
		return this.boonPercent;
	}

	public void setBoonPercent(Float boonPercent) {
		this.boonPercent = boonPercent;
	}

	public String getBoonRemark() {
		return this.boonRemark;
	}

	public void setBoonRemark(String boonRemark) {
		this.boonRemark = boonRemark;
	}

}