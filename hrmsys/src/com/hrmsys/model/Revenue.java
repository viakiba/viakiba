package com.hrmsys.model;

/**
 * Revenue entity. @author MyEclipse Persistence Tools
 */

public class Revenue implements java.io.Serializable {

	// Fields

	private Integer reId;
	private Float reMin;
	private Float reMax;
	private Float rePercent;
	private Float reMinus;

	// Constructors

	/** default constructor */
	public Revenue() {
	}

	/** full constructor */
	public Revenue(Float reMin, Float reMax, Float rePercent, Float reMinus) {
		this.reMin = reMin;
		this.reMax = reMax;
		this.rePercent = rePercent;
		this.reMinus = reMinus;
	}

	// Property accessors

	public Integer getReId() {
		return this.reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	public Float getReMin() {
		return this.reMin;
	}

	public void setReMin(Float reMin) {
		this.reMin = reMin;
	}

	public Float getReMax() {
		return this.reMax;
	}

	public void setReMax(Float reMax) {
		this.reMax = reMax;
	}

	public Float getRePercent() {
		return this.rePercent;
	}

	public void setRePercent(Float rePercent) {
		this.rePercent = rePercent;
	}

	public Float getReMinus() {
		return this.reMinus;
	}

	public void setReMinus(Float reMinus) {
		this.reMinus = reMinus;
	}

}