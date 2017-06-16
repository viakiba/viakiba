package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.model.Department;
import com.hrmsys.model.Job;

public interface JobDAO {
	/**
	 * 查询出所有JOB中的内容
	 * @return Job集合
	 */
	List<Job> findAll(int start, int limit);

	/**
	 * 查询出某部门的所有职位
	 * @param dept
	 * @return Job集合
	 */
	PageBean findByDeptId(String deptId, int start, int limit);
	/**
	 * 删除
	 * @param deptId
	 * @return
	 */
	boolean delete(String[] deptIds);
	/**
	 * 保存或修改
	 * @param job
	 * @return
	 */
	boolean saveOrUpdate(Job job);
	/**
	 * 按jobId查询
	 * @param parseInt
	 * @return
	 */
	Job findByJobId(int jobId);
	/**
	 * 查询记录数
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public<T> int findTotal(Class<T> clazz);
	/**
	 * 按部门id查询
	 * @param deptId
	 */
	List<Job> findByDeptId(String deptId);
	/**
	 * 职位名称校验 
	 * @param jobName
	 * @return
	 */
	boolean uniqueJobName(String jobName);
}
