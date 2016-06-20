package haust.vk.c_hbm_config;

import java.util.Date;

/**
 * @author vk
 *
 * 2016年6月20日
 */
public class Employee {
	private String empId ;
	private String empName;
	private Date workDate;
	// 描述
	private String desc;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", workDate=" + workDate + ", desc=" + desc + "]";
	}
	
	
}
