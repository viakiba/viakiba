package haust.vk.entity;

/**
 * @author vk
 *
 * 2016年4月22日
 */
public class Employee {
	private int empId;
	private String empName;
	private int dept_id;
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
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", dept_id=" + dept_id + "]";
	}
	
}
