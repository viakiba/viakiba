package com.hrmsys.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.JobDAO;
import com.hrmsys.model.Department;
import com.hrmsys.model.Job;

public class JobDAOImpl extends BaseDAO implements JobDAO{
	private static final Log log = LogFactory.getLog(JobDAOImpl.class);
	// property constants
	public static final String JOB_NAME = "jobName";
	public static final String JOB_REMARK = "jobRemark";
	public static final String JOB_DEPARTMENT = "department";
	
	protected void initDao() {
		// do nothing
	}

	@Override
	public List<Job> findAll(int start, int limit) {
		String hql = "FROM Job";
		return super.page(hql, start, limit);
	}

	@Override
	public PageBean findByDeptId(String deptId, int start, int limit) {
		//return super.findByProperty(Job.class, JOB_DEPARTMENT, dept);
		String hql = "FROM Job WHERE department.deptId = "+deptId;
		PageBean pageBean = new PageBean();
		pageBean.setRoot(page(hql , start, limit));
		pageBean.setTotalProperty(this.findByHQL(hql).size());
		return pageBean;
	}
	@Override
	public boolean delete(String[] deptIds){
		boolean flag = true;
		for(String deptId : deptIds){
			if(!super.deleteById(Job.class, Integer.parseInt(deptId)))
				flag = false;
		}
		return flag;
	}

	@Override
	public boolean saveOrUpdate(Job job) {
		return super.saveOrUpdate(job);
	}

	@Override
	public Job findByJobId(int jobId) {
		List<Job> jobs = super.findByProperty(Job.class, "jobId", jobId);
		if(jobs.size() > 0){
			return jobs.get(0);
		}
		return null;
	}

	@Override
	public List<Job> findByDeptId(String deptId) {
		String hql = "FROM Job WHERE department.deptId = ?";
		return super.findByHQLAndValue(hql, deptId);
	}

	@Override
	public boolean uniqueJobName(String jobName) {
		String hql = "FROM Job WHERE jobName = ?";
		List<Job> jobs = this.findByHQLAndValue(hql, jobName);
		if(jobs.size() > 0){
			return false;
		}
		return true;
	}
	
}