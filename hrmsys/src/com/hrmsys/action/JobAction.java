package com.hrmsys.action;

import com.hrmsys.model.Department;
import com.hrmsys.model.Job;
import com.hrmsys.service.JobService;
import com.hrmsys.util.ConditionValidate;

public class JobAction extends BaseAction{
	private JobService jobService;
	private String ids;
	private Job job;
	private String jobId;
	private String start;
	private String limit;
	private String jobName;
	
	/**
	 * 部门ID
	 */
	private String deptId = null;
	
	public void list(){
		String json = null;
		if(deptId != null && !"".equals(deptId)){
			if(ConditionValidate.isEmpty(start) && ConditionValidate.isEmpty(limit)){
				json = jobService.getJobByDeptId(deptId, start, limit);//按部门查询
			}else{
				json = jobService.getJobByDeptId(deptId);
			}
		}else{
			json = jobService.getAll(start, limit);//查询所有
		}
		this.setStart(null);
		this.setLimit(null);
		this.out(json);
	}
	
	public void delete(){
		String msg = jobService.delete(this.getIds());
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public void intoUpdate(){
		String jobJson = jobService.getById(jobId);
		this.out(jobJson);
	}
	
	public void saveOrUpdate(){
		Department dept = new Department();
		dept.setDeptId(deptId);
		job.setDepartment(dept);
		String msg = jobService.saveOrUpdate(job);
		this.setJob(null);//避免再次添加时还存在jobId值，导致变成修改
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	/**
	 * 职位名称进行唯一性校验
	 */
	public void unique(){
		String msg = jobService.unique(jobName);
		this.out("{success: true, msg: '"+msg+"'}");
	}
	
	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
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

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}
