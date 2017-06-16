package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.model.Department;
import com.hrmsys.model.Employee;

public interface EmployeeDAO {
	/**
	 * 按部门查询
	 * @param dept
	 * @return
	 */
	List<Employee> findByDept(Department dept);
	/**
	 * 查询所有
	 * @return 所有Employee
	 */
	List<Employee> findAll(int start, int limit);
	/**
	 * 按条件查询
	 * @param dept
	 * @param condition
	 * @param conditionValue
	 * @return 集合
	 */
	PageBean findByHQL(String dept, String condition,
			String conditionValue, int start, int limit);
	/**
	 * 保存员工信息
	 * @param emp
	 */
	boolean save(Employee emp);
	/**
	 * 按工号查询
	 * @param empId
	 * @return
	 */
	Employee findByEmpId(String empId);
	/**
	 * 删除
	 * @param empId
	 * @return
	 */
	boolean deleteByEmpId(String[] empIds);
	/**
	 * 保存或修改
	 * @param emp
	 * @return
	 */
	boolean saveOrUpdate(Employee emp);
	public<T> int findTotal(Class<T> clazz);
	public <T> List<T> findAll(Class<T> clazz);
	/**
	 * 修改
	 * @param emp
	 */
	boolean update(Employee emp);
}
