package haust.vk.c_many2many;

import java.util.HashSet;
import java.util.Set;

public class Project {
	private int prj_id;
	private String prj_name;
	// 项目下的多个员工
	private Set<Developer> developers = new HashSet<Developer>();
	
	public int getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(int prj_id) {
		this.prj_id = prj_id;
	}
	public String getPrj_name() {
		return prj_name;
	}
	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}
	public Set<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
	}
}
