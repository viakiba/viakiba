package haust.vk.entity;

import java.util.Date;

/**
 * @author vk
 *
 * 2016年6月18日
 */
public class Employee {
	private int id;
	private String empName;
	private Date workDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
}
