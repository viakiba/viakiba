package com.hrmsys.service;

import com.hrmsys.model.Job;

public interface JobService {

	/**
	 * 获取所有职位
	 * @return 返回JSON格式的字符串
	 */
	String getAll(String start, String limit);
	/**
	 * 获取某部门的职位
	 * @param deptId
	 * @return 返回JSON格式的字符串
	 */
	String getJobByDeptId(String deptId, String start, String limit);
	/**
	 * 删除部门职位
	 * @param ids
	 * @return
	 */
	String delete(String ids);
	/**
	 * 保存或更新
	 * @param job
	 * @return
	 */
	String saveOrUpdate(Job job);
	/**
	 * 按职位编号查询
	 * @param jobId
	 * @return
	 */
	String getById(String jobId);
	/**
	 * 按部门id查询
	 * @param deptId
	 * @return
	 */
	String getJobByDeptId(String deptId);
	/**
	 * 职位名称进行唯一性校验 
	 * @param jobName
	 * @return
	 */
	String unique(String jobName);
}
