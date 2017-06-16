package com.hrmsys.model;

/**
 * SalaryBasic entity. @author MyEclipse Persistence Tools
 */

public class SalaryBasic implements java.io.Serializable {

	// Fields

	private Integer sbId;
	private Employee employee;
	private Float sbBasic;
	private Integer sbEndowment;
	private Integer sbHospitalization;
	private Integer sbUnemployment;
	private Integer sbInjury;
	private Integer sbMaternity;
	private Integer sbHousing;
	private Float sbTraffic;
	private Float sbEatery;
	private Float sbTelephone;

	// Constructors

	/** default constructor */
	public SalaryBasic() {
	}

	/** minimal constructor */
	public SalaryBasic(Employee employee) {
		this.employee = employee;
	}

	/** full constructor */
	public SalaryBasic(Employee employee, Float sbBasic, Integer sbEndowment,
			Integer sbHospitalization, Integer sbUnemployment,
			Integer sbInjury, Integer sbMaternity, Integer sbHousing,
			Float sbTraffic, Float sbEatery, Float sbTelephone) {
		this.employee = employee;
		this.sbBasic = sbBasic;
		this.sbEndowment = sbEndowment;
		this.sbHospitalization = sbHospitalization;
		this.sbUnemployment = sbUnemployment;
		this.sbInjury = sbInjury;
		this.sbMaternity = sbMaternity;
		this.sbHousing = sbHousing;
		this.sbTraffic = sbTraffic;
		this.sbEatery = sbEatery;
		this.sbTelephone = sbTelephone;
	}

	// Property accessors

	public Integer getSbId() {
		return this.sbId;
	}

	public void setSbId(Integer sbId) {
		this.sbId = sbId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Float getSbBasic() {
		return this.sbBasic;
	}

	public void setSbBasic(Float sbBasic) {
		this.sbBasic = sbBasic;
	}

	public Integer getSbEndowment() {
		return this.sbEndowment;
	}

	public void setSbEndowment(Integer sbEndowment) {
		this.sbEndowment = sbEndowment;
	}

	public Integer getSbHospitalization() {
		return this.sbHospitalization;
	}

	public void setSbHospitalization(Integer sbHospitalization) {
		this.sbHospitalization = sbHospitalization;
	}

	public Integer getSbUnemployment() {
		return this.sbUnemployment;
	}

	public void setSbUnemployment(Integer sbUnemployment) {
		this.sbUnemployment = sbUnemployment;
	}

	public Integer getSbInjury() {
		return this.sbInjury;
	}

	public void setSbInjury(Integer sbInjury) {
		this.sbInjury = sbInjury;
	}

	public Integer getSbMaternity() {
		return this.sbMaternity;
	}

	public void setSbMaternity(Integer sbMaternity) {
		this.sbMaternity = sbMaternity;
	}

	public Integer getSbHousing() {
		return this.sbHousing;
	}

	public void setSbHousing(Integer sbHousing) {
		this.sbHousing = sbHousing;
	}

	public Float getSbTraffic() {
		return this.sbTraffic;
	}

	public void setSbTraffic(Float sbTraffic) {
		this.sbTraffic = sbTraffic;
	}

	public Float getSbEatery() {
		return this.sbEatery;
	}

	public void setSbEatery(Float sbEatery) {
		this.sbEatery = sbEatery;
	}

	public Float getSbTelephone() {
		return this.sbTelephone;
	}

	public void setSbTelephone(Float sbTelephone) {
		this.sbTelephone = sbTelephone;
	}

}