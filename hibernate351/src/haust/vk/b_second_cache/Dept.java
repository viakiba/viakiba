package haust.vk.b_second_cache;

import java.util.HashSet;
import java.util.Set;

public class Dept {
	private int deptId;
	private String deptName;
	//对应的员工
	private Set<Employee> emps=new HashSet<Employee>();
	
	public Dept(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}
	
	public Dept() {
		super();
	}
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	
	
}
