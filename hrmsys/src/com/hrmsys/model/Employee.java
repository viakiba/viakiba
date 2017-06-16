package com.hrmsys.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */

public class Employee implements java.io.Serializable {

	// Fields

	private Job job;
	private Department department;
	private String empId;
	private String empName;
	private Integer empSex;
	private Date empBirth;
	private String empAddress;
	private String empPost;
	private String empTelephone;
	private String empMobilephone;
	private String empQq;
	private String empEmail;
	private String empAccount;
	private String empIdcard;
	private String empPhoto;
	private Date empAddDate;
	private String empAddPerson;
	private String empBank;
	private String empNationality;
	private String empOrigin;
	private String empNation;
	private String empSchool;
	private String empEducation;
	private String empProfession;
	private Set trains = new HashSet(0);
	private Set salaries = new HashSet(0);
	private Set jobChanges = new HashSet(0);
	private Set users = new HashSet(0);
	private Set encouragePunishs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */
	public Employee(String empId,Department department, String empName,
			Integer empSex, Date empBirth, String empAddress, String empPost,
			String empMobilephone, String empEmail, String empAccount,
			String empIdcard, Date empAddDate, String empAddPerson,
			String empBank) {
		this.empId = empId;
		this.department = department;
		this.empName = empName;
		this.empSex = empSex;
		this.empBirth = empBirth;
		this.empAddress = empAddress;
		this.empPost = empPost;
		this.empMobilephone = empMobilephone;
		this.empEmail = empEmail;
		this.empAccount = empAccount;
		this.empIdcard = empIdcard;
		this.empAddDate = empAddDate;
		this.empAddPerson = empAddPerson;
		this.empBank = empBank;
	}

	/** full constructor */
	public Employee(String empId, Job job, Department department,
			String empName, Integer empSex, Date empBirth, String empAddress,
			String empPost, String empTelephone, String empMobilephone,
			String empQq, String empEmail, String empAccount, String empIdcard,
			String empPhoto, Date empAddDate, String empAddPerson,
			String empBank, String empNationality,
			String empOrigin, String empNation, String empSchool,
			String empEducation, String empProfession, Set trains,
			Set salaries, Set jobChanges, Set users, Set encouragePunishs) {
		this.job = job;
		this.empId = empId;
		this.department = department;
		this.empName = empName;
		this.empSex = empSex;
		this.empBirth = empBirth;
		this.empAddress = empAddress;
		this.empPost = empPost;
		this.empTelephone = empTelephone;
		this.empMobilephone = empMobilephone;
		this.empQq = empQq;
		this.empEmail = empEmail;
		this.empAccount = empAccount;
		this.empIdcard = empIdcard;
		this.empPhoto = empPhoto;
		this.empAddDate = empAddDate;
		this.empAddPerson = empAddPerson;
		this.empBank = empBank;
		this.empNationality = empNationality;
		this.empOrigin = empOrigin;
		this.empNation = empNation;
		this.empSchool = empSchool;
		this.empEducation = empEducation;
		this.empProfession = empProfession;
		this.trains = trains;
		this.salaries = salaries;
		this.jobChanges = jobChanges;
		this.users = users;
		this.encouragePunishs = encouragePunishs;
	}

	// Property accessors

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpSex() {
		return this.empSex;
	}

	public void setEmpSex(Integer empSex) {
		this.empSex = empSex;
	}

	public Date getEmpBirth() {
		return this.empBirth;
	}

	public void setEmpBirth(Date empBirth) {
		this.empBirth = empBirth;
	}

	public String getEmpAddress() {
		return this.empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpPost() {
		return this.empPost;
	}

	public void setEmpPost(String empPost) {
		this.empPost = empPost;
	}

	public String getEmpTelephone() {
		return this.empTelephone;
	}

	public void setEmpTelephone(String empTelephone) {
		this.empTelephone = empTelephone;
	}

	public String getEmpMobilephone() {
		return this.empMobilephone;
	}

	public void setEmpMobilephone(String empMobilephone) {
		this.empMobilephone = empMobilephone;
	}

	public String getEmpQq() {
		return this.empQq;
	}

	public void setEmpQq(String empQq) {
		this.empQq = empQq;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpAccount() {
		return this.empAccount;
	}

	public void setEmpAccount(String empAccount) {
		this.empAccount = empAccount;
	}

	public String getEmpIdcard() {
		return this.empIdcard;
	}

	public void setEmpIdcard(String empIdcard) {
		this.empIdcard = empIdcard;
	}

	public String getEmpPhoto() {
		return this.empPhoto;
	}

	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}

	public Date getEmpAddDate() {
		return this.empAddDate;
	}

	public void setEmpAddDate(Date empAddDate) {
		this.empAddDate = empAddDate;
	}

	public String getEmpAddPerson() {
		return this.empAddPerson;
	}

	public void setEmpAddPerson(String empAddPerson) {
		this.empAddPerson = empAddPerson;
	}

	public String getEmpBank() {
		return this.empBank;
	}

	public void setEmpBank(String empBank) {
		this.empBank = empBank;
	}

	public String getEmpNationality() {
		return this.empNationality;
	}

	public void setEmpNationality(String empNationality) {
		this.empNationality = empNationality;
	}

	public String getEmpOrigin() {
		return this.empOrigin;
	}

	public void setEmpOrigin(String empOrigin) {
		this.empOrigin = empOrigin;
	}

	public String getEmpNation() {
		return this.empNation;
	}

	public void setEmpNation(String empNation) {
		this.empNation = empNation;
	}

	public String getEmpSchool() {
		return this.empSchool;
	}

	public void setEmpSchool(String empSchool) {
		this.empSchool = empSchool;
	}

	public String getEmpEducation() {
		return this.empEducation;
	}

	public void setEmpEducation(String empEducation) {
		this.empEducation = empEducation;
	}

	public String getEmpProfession() {
		return this.empProfession;
	}

	public void setEmpProfession(String empProfession) {
		this.empProfession = empProfession;
	}

	public Set getTrains() {
		return this.trains;
	}

	public void setTrains(Set trains) {
		this.trains = trains;
	}

	public Set getSalaries() {
		return this.salaries;
	}

	public void setSalaries(Set salaries) {
		this.salaries = salaries;
	}

	public Set getJobChanges() {
		return this.jobChanges;
	}

	public void setJobChanges(Set jobChanges) {
		this.jobChanges = jobChanges;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getEncouragePunishs() {
		return this.encouragePunishs;
	}

	public void setEncouragePunishs(Set encouragePunishs) {
		this.encouragePunishs = encouragePunishs;
	}

}