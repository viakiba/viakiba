package com.hrmsys.action;

import com.hrmsys.bean.DepartmentBean;
import com.hrmsys.model.Department;
import com.hrmsys.service.DeptService;
import com.hrmsys.util.ConditionValidate;

public class DeptAction extends BaseAction{
	private DeptService deptService;
	private Department dept;
	private DepartmentBean deptBean;
	private String start;
	private String limit;
	/**
	 * 按条件查询的属性名
	 */
	private String condition;
	/**
	 * 按条件查询的内容
	 */
	private String conditionValue;
	/**
	 * 删除的部门的编号字符串
	 */
	private String ids;
	private String deptId;
	
	public void list(){
		String deptJson = null;
		if(ConditionValidate.isEmpty(conditionValue) && ConditionValidate.isEmpty(condition)){
			deptJson = deptService.getDeptByCondition(condition, conditionValue, start, limit);
		}else{
			deptJson = deptService.getAll(start, limit);
		}
		this.setStart(null);
		this.setLimit(null);
		this.setCondition(null);
		this.setConditionValue(null);
		this.out(deptJson);
	}
	
	public void show(){
		String deptJson = deptService.getAll();
		this.out(deptJson);
	}
	
	public void save(){
		String msg = deptService.save(dept);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void delete(){
		String msg = deptService.delete(this.getIds());
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void intoUpdate(){
		String deptJson = deptService.listById(deptId);
		this.out(deptJson);
	}
	
	public void report(){
		String deptXML = deptService.getReportDate();
		this.out(deptXML);
	}
	
	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public DepartmentBean getDeptBean() {
		return deptBean;
	}

	public void setDeptBean(DepartmentBean deptBean) {
		this.deptBean = deptBean;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getConditionValue() {
		return conditionValue;
	}

	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}
	
}
