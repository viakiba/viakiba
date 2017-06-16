package com.hrmsys.service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.JobDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.Department;
import com.hrmsys.model.Job;
import com.hrmsys.service.JobService;

public class JobServiceImpl implements JobService{
	private JobDAO jobDAO;

	@Override
	public String getAll(String start, String limit) {
		String json = null;
		List<Job> jobs = jobDAO.findAll(Integer.parseInt(start), Integer.parseInt(limit));
		if(jobs.size() != 0){
			 json = JSONArray.fromObject(jobs).toString();
		}
		int totalProperty = jobDAO.findTotal(Job.class);
		return "{totalProperty:"+totalProperty+",root:"+json+"}";
	}
	
	@Override
	public String getJobByDeptId(String deptId, String start, String limit) {
		String json = null;
		PageBean pageBean = jobDAO.findByDeptId(deptId, Integer.parseInt(start), Integer.parseInt(limit));
		if(pageBean.getRoot().size() > 0){
			json = JSONArray.fromObject(pageBean.getRoot()).toString();
		}
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+json+"}";
	}
	
	@Override
	public String getJobByDeptId(String deptId){
		List<Job> jobs = jobDAO.findByDeptId(deptId);
		return JSONArray.fromObject(jobs).toString();
	}
	
	@Override
	public String delete(String ids) {
		String[] deptId = ids.split(",");
		if(jobDAO.delete(deptId)) return StaticValue.DELETE_SUCCESS;
		return StaticValue.DELETE_FAILURE;
	}
	
	@Override
	public String saveOrUpdate(Job job) {
		if(jobDAO.saveOrUpdate(job)){
			return StaticValue.SAVE_SUCCESS;
		}
		return StaticValue.SAVE_FAILURE;
	}
	
	@Override
	public String getById(String jobId) {
		Job job = jobDAO.findByJobId(Integer.parseInt(jobId));
		return JSONArray.fromObject(job).toString();
	}
	
	@Override
	public String unique(String jobName) {
		if(!jobDAO.uniqueJobName(jobName)){
			return jobName;
		}
		return "";
	}
	
	/**follow is getter and setter**/
	public JobDAO getJobDAO() {
		return jobDAO;
	}

	public void setJobDAO(JobDAO jobDAO) {
		this.jobDAO = jobDAO;
	}

}
