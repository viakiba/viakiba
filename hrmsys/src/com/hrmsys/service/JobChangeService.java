package com.hrmsys.service;

import java.util.List;

import com.hrmsys.model.JobChange;

public interface JobChangeService {
	/**
	 * 查询员工调动信息表
	 * @return
	 */
	String getAllJobChange(String start, String limit);
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	String delete(String ids);
	/**
	 * 保存
	 * @return
	 */
	String save(JobChange jobChange);
	/**
	 * 按条件查询
	 * @param condition
	 * @param conditionValue
	 * @param start
	 * @param limit
	 * @return
	 */
	String getAllJobChange(String condition, String conditionValue,
			String start, String limit);
	/**
	 * 按id查询
	 * @param jcId
	 * @return
	 */
	String getJobChangeById(int jcId);
	/**
	 * 修改
	 * @param jobChange
	 * @return
	 */
	String update(JobChange jobChange);
}
