package com.hrmsys.action;

import java.io.IOException;

import com.hrmsys.bean.SalaryBasicBean;
import com.hrmsys.service.SalaryBasicService;

public class SalaryBasicAction extends BaseAction{
	private SalaryBasicService salaryBasicService;
	private String type;
	private String condition;
	private String conditionValue;
	private String ids;
	private String json;
	private SalaryBasicBean salBasicBean;
	private String start;
	private String limit;
	private String empId;
	
	public void list(){
		String sbJson = null;
		if("query".equals(type)){
			salBasicBean = new SalaryBasicBean();
			if("empId".equals(condition)){
				salBasicBean.setEmpId(conditionValue);
			}
			if("empName".equals(condition)){
				salBasicBean.setEmpName(conditionValue);
			}
			sbJson = salaryBasicService.getListByCondition(salBasicBean, start, limit);
			this.setType(null);
		}else{
			sbJson = salaryBasicService.list(start, limit);
		}
		this.out(sbJson);
	}
	
	public void delete(){
		String msg = salaryBasicService.delete(ids);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void save(){
		String msg = salaryBasicService.saveOrUpdate(json);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	/**
	 * 判断员工工资是否已配置
	 */
	public void uniqueEmp(){
		boolean msg = salaryBasicService.uniqueEmp(empId);
		this.out("{success: true, msg: "+msg+"}");
	}
	
	
	public SalaryBasicService getSalaryBasicService() {
		return salaryBasicService;
	}

	public void setSalaryBasicService(SalaryBasicService salaryBasicService) {
		this.salaryBasicService = salaryBasicService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public SalaryBasicBean getSalBasicBean() {
		return salBasicBean;
	}

	public void setSalBasicBean(SalaryBasicBean salBasicBean) {
		this.salBasicBean = salBasicBean;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
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

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
}
