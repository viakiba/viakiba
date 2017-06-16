package com.hrmsys.service;

import java.util.List;

import com.hrmsys.bean.DepartmentBean;
import com.hrmsys.model.Department;

public interface DeptService {
	/**
	 * 查询所有部门
	 * @param type
	 * @return
	 */
	public String getAll(String start, String limit);
	/**
	* 方法名：
	* 描     述：保存部门
	* 参数: dept
	* 创建人：sux
	* 创建时间:2011-2-18
	* @return msg
	 */
	public String save(Department dept);
	/**
	 * 删除部门
	 * @param ids 部门编号序列
	 * @return
	 */
	public String delete(String ids);
	/**
	 * 按条件查询
	 * @param condition
	 * @param conditionValue
	 * @return json
	 */
	public String getDeptByCondition(String condition, String conditionValue, String start, String limit);
	/**
	 * 按id查询
	 * @param deptId
	 * @return
	 */
	public String listById(String deptId);
	/**
	 * 查询数据转为FusionChart所需的XML格式 
	 * @return
	 */
	public String getReportDate();
	public String getAll();

}
