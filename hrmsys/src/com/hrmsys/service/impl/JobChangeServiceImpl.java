package com.hrmsys.service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.EmployeeDAO;
import com.hrmsys.dao.JobChangeDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.Employee;
import com.hrmsys.model.Job;
import com.hrmsys.model.JobChange;
import com.hrmsys.service.JobChangeService;

public class JobChangeServiceImpl implements JobChangeService{
	private JobChangeDAO jobChangeDAO;
	private EmployeeDAO empDAO;
	
	@Override
	public String getAllJobChange(String start, String limit) {
		List<JobChange> jobChanges = jobChangeDAO.findAll(start, limit);
		String root = JSONArray.fromObject(jobChanges).toString();
		int totalProperty = jobChangeDAO.findTotal(JobChange.class);
		return "{totalProperty:"+totalProperty+",root:"+root+"}";
	}

	@Override
	public String delete(String ids) {
		String[] jcIds = ids.split(",");
		if(jobChangeDAO.delete(jcIds)){
			return StaticValue.DELETE_SUCCESS;
		}
		return StaticValue.DELETE_FAILURE;
	}

	@Override
	public String save(JobChange jobChange) {
		if(jobChangeDAO.save(jobChange)){
			Employee emp = empDAO.findByEmpId(jobChange.getEmployee().getEmpId());
			emp.setJob(jobChange.getJobByJcNewJob());
			emp.setDepartment(jobChange.getDepartmentByJcNewDept());
			empDAO.update(emp);
			return StaticValue.SAVE_SUCCESS;
		}
		return StaticValue.SAVE_FAILURE;
	}
	
	@Override
	public String getAllJobChange(String condition, String conditionValue,
			String start, String limit) {
		PageBean pageBean = jobChangeDAO.findAll(condition, conditionValue, start, limit);
		String root = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+root+"}";
	}
	
	@Override
	public String getJobChangeById(int jcId) {
		JobChange jobChanges = jobChangeDAO.findById(jcId);
		return JSONArray.fromObject(jobChanges).toString();
	}

	@Override
	public String update(JobChange jobChange) {
		if(jobChangeDAO.update(jobChange)){
			Employee emp = empDAO.findByEmpId(jobChange.getEmployee().getEmpId());
			emp.setJob(jobChange.getJobByJcNewJob());
			emp.setDepartment(jobChange.getDepartmentByJcNewDept());
			empDAO.update(emp);
			return StaticValue.UPDATE_SUCCESS;
		}
		return StaticValue.UPDATE_FAILURE;
	}
	
	/***setter and getter**********************/
	public JobChangeDAO getJobChangeDAO() {
		return jobChangeDAO;
	}

	public void setJobChangeDAO(JobChangeDAO jobChangeDAO) {
		this.jobChangeDAO = jobChangeDAO;
	}

	public EmployeeDAO getEmpDAO() {
		return empDAO;
	}

	public void setEmpDAO(EmployeeDAO empDAO) {
		this.empDAO = empDAO;
	}
}
