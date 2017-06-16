package com.hrmsys.service;

import com.hrmsys.bean.SalaryBasicBean;

public interface SalaryBasicService {
	/**
	 * 查询清单
	 * @return
	 */
	String list(String start, String limit);

	String getListByCondition(SalaryBasicBean salBasicBean, String start, String limit);
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	String delete(String ids);
	/**
	 * 保存或修改
	 * @param json
	 * @return
	 */
	String saveOrUpdate(String json);
	/**
	 * 判断是否已配置
	 * @param empId
	 * @return
	 */
	boolean uniqueEmp(String empId);

}
