package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.model.JobChange;

public interface JobChangeDAO {
	/**
	 * 查询所有
	 * @return
	 */
	public List<JobChange> findAll(String start, String limit);
	/**
	 * 删除
	 * @param jcIds
	 * @return
	 */
	public boolean delete(String[] jcIds);
	/**
	 * 保存
	 * @param jobChange
	 * @return
	 */
	public boolean save(JobChange jobChange);
	
	public<T> int findTotal(Class<T> clazz);
	/**
	 * 按条件查询
	 * @param condition
	 * @param conditionValue
	 * @param start
	 * @param limit
	 * @return
	 */
	public PageBean findAll(String condition, String conditionValue,
			String start, String limit);
	/**
	 * 按id查询
	 * @param jcId
	 * @return
	 */
	public JobChange findById(int jcId);
	
	/**
	 * 修改
	 * @param jobChange
	 * @return
	 */
	public boolean update(JobChange jobChange);
}
