package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.model.Department;

public interface DepartmentDAO {
	/**
	 * 查询所有
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public List<Department> findAllDept(String start, String limit);
	/**
	 * 保存部门
	 * @param dept
	 * @return
	 */
	public boolean save(Department dept);
	/**
	 * 删除部门
	 * @param ids
	 */
	public boolean delete(String[] deptIds);
	/**
	 * 按条件查询
	 * @param 
	 * @return list
	 */
	public PageBean findDeptByCondition(String condition,
			String conditionValue, int start, int limit);
	/**
	 * 修改或保存
	 * @param dept
	 * @return
	 */
	public boolean saveOrUpdate(Department dept);
	/**
	 * 按id查询
	 * @param deptId
	 * @return
	 */
	public List<Department> findById(String deptId);
	/**
	 * 查询记录数
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public<T> int findTotal(Class<T> clazz);
	public <T> List<T> findAll(Class<T> clazz);
}
