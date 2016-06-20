package haust.vk.a_hello;

import java.util.Date;

/**
 * @author vk
 *
 * 2016年6月19日
 */
public class Employee {
	private int empId;
	private String empName;
	private Date workDate;
	
	public Employee(){
		this.empName="王五";
		this.workDate=new Date();
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
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
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", workDate=" + workDate + "]";
	}
	
	
}
