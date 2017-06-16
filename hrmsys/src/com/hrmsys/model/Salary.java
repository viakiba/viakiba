package com.hrmsys.model;

import java.util.Date;

/**
 * Salary entity. @author MyEclipse Persistence Tools
 */

public class Salary implements java.io.Serializable {

	// Fields

	private Integer salId;
	private Employee employee;
	private Float salBasic;
	private Float salJob;
	private Float salNormal;
	private Float salAll;
	private Float salAbsenteeism;
	private Float salAbsenteeismMoney;
	private Float salEndowmentint;
	private Float salHospitalizationint;
	private Float salUnemploymentint;
	private Float salEateryfloat;
	private Float salTrafficfloat;
	private Float salTelephone;
	private Float salAllowance;
	private Float salRevenue;
	private Float salMoney;
	private String salYear;
	private String salReleasePerson;
	private Date salReleaseDate;
	private int salMonth;
	private String salRemark;

	// Constructors

	/** default constructor */
	public Salary() {
	}

	/** full constructor */
	public Salary(Employee employee, Float salBasic, Float salJob,
			Float salNormal, Float salAll, Float salAbsenteeism,
			Float salAbsenteeismMoney, Float salEndowmentint,
			Float salHospitalizationint, Float salUnemploymentint,
			Float salEateryfloat, Float salTrafficfloat, Float salTelephone,
			Float salAllowance, Float salRevenue, Float salMoney, String salYear,
			String salReleasePerson, Date salReleaseDate,
			int salMonth, String salRemark) {
		this.employee = employee;
		this.salBasic = salBasic;
		this.salJob = salJob;
		this.salNormal = salNormal;
		this.salAll = salAll;
		this.salAbsenteeism = salAbsenteeism;
		this.salAbsenteeismMoney = salAbsenteeismMoney;
		this.salEndowmentint = salEndowmentint;
		this.salHospitalizationint = salHospitalizationint;
		this.salUnemploymentint = salUnemploymentint;
		this.salEateryfloat = salEateryfloat;
		this.salTrafficfloat = salTrafficfloat;
		this.salTelephone = salTelephone;
		this.salAllowance = salAllowance;
		this.salRevenue = salRevenue;
		this.salMoney = salMoney;
		this.salYear = salYear;
		this.salReleasePerson = salReleasePerson;
		this.salReleaseDate = salReleaseDate;
		this.salMonth = salMonth;
		this.salRemark = salRemark;
	}

	// Property accessors

	public Integer getSalId() {
		return this.salId;
	}

	public void setSalId(Integer salId) {
		this.salId = salId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Float getSalBasic() {
		return this.salBasic;
	}

	public void setSalBasic(Float salBasic) {
		this.salBasic = salBasic;
	}

	public Float getSalJob() {
		return this.salJob;
	}

	public void setSalJob(Float salJob) {
		this.salJob = salJob;
	}

	public Float getSalNormal() {
		return this.salNormal;
	}

	public void setSalNormal(Float salNormal) {
		this.salNormal = salNormal;
	}

	public Float getSalAll() {
		return this.salAll;
	}

	public void setSalAll(Float salAll) {
		this.salAll = salAll;
	}

	public Float getSalAbsenteeism() {
		return this.salAbsenteeism;
	}

	public void setSalAbsenteeism(Float salAbsenteeism) {
		this.salAbsenteeism = salAbsenteeism;
	}

	public Float getSalAbsenteeismMoney() {
		return this.salAbsenteeismMoney;
	}

	public void setSalAbsenteeismMoney(Float salAbsenteeismMoney) {
		this.salAbsenteeismMoney = salAbsenteeismMoney;
	}

	public Float getSalEndowmentint() {
		return this.salEndowmentint;
	}

	public void setSalEndowmentint(Float salEndowmentint) {
		this.salEndowmentint = salEndowmentint;
	}

	public Float getSalHospitalizationint() {
		return this.salHospitalizationint;
	}

	public void setSalHospitalizationint(Float salHospitalizationint) {
		this.salHospitalizationint = salHospitalizationint;
	}

	public Float getSalUnemploymentint() {
		return this.salUnemploymentint;
	}

	public void setSalUnemploymentint(Float salUnemploymentint) {
		this.salUnemploymentint = salUnemploymentint;
	}

	public Float getSalEateryfloat() {
		return this.salEateryfloat;
	}

	public void setSalEateryfloat(Float salEateryfloat) {
		this.salEateryfloat = salEateryfloat;
	}

	public Float getSalTrafficfloat() {
		return this.salTrafficfloat;
	}

	public void setSalTrafficfloat(Float salTrafficfloat) {
		this.salTrafficfloat = salTrafficfloat;
	}

	public Float getSalTelephone() {
		return this.salTelephone;
	}

	public void setSalTelephone(Float salTelephone) {
		this.salTelephone = salTelephone;
	}

	public Float getSalAllowance() {
		return this.salAllowance;
	}

	public void setSalAllowance(Float salAllowance) {
		this.salAllowance = salAllowance;
	}

	public Float getSalRevenue() {
		return this.salRevenue;
	}

	public void setSalRevenue(Float salRevenue) {
		this.salRevenue = salRevenue;
	}

	public Float getSalMoney() {
		return this.salMoney;
	}

	public void setSalMoney(Float salMoney) {
		this.salMoney = salMoney;
	}


	public String getSalYear() {
		return salYear;
	}

	public void setSalYear(String salYear) {
		this.salYear = salYear;
	}

	public String getSalReleasePerson() {
		return this.salReleasePerson;
	}

	public void setSalReleasePerson(String salReleasePerson) {
		this.salReleasePerson = salReleasePerson;
	}

	public Date getSalReleaseDate() {
		return this.salReleaseDate;
	}

	public void setSalReleaseDate(Date salReleaseDate) {
		this.salReleaseDate = salReleaseDate;
	}

	public String getSalRemark() {
		return this.salRemark;
	}

	public void setSalRemark(String salRemark) {
		this.salRemark = salRemark;
	}

	public int getSalMonth() {
		return salMonth;
	}

	public void setSalMonth(int salMonth) {
		this.salMonth = salMonth;
	}

}