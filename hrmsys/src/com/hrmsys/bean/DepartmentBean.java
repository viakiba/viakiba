package com.hrmsys.bean;

public class DepartmentBean {
	private String deptId;
	private String deptName;
	private String deptRemark;
	private String deptMgr; //部门经理
	private Integer deptNum; //部门人数
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptRemark() {
		return deptRemark;
	}
	public void setDeptRemark(String deptRemark) {
		this.deptRemark = deptRemark;
	}
	public String getDeptMgr() {
		return deptMgr;
	}
	public void setDeptMgr(String deptMgr) {
		this.deptMgr = deptMgr;
	}
	public Integer getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(Integer deptNum) {
		this.deptNum = deptNum;
	}
	
}
