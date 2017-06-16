package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.SalaryBean;
import com.hrmsys.model.Salary;

public interface SalaryDAO {
	/**
	 * 保存
	 * @param salary
	 * @return
	 */
	boolean saveOrUpdate(Salary salary);
	/**
	 * 查询所有
	 * @return
	 */
	PageBean findAll(String start, String limit);
	/**
	 * 条件查询
	 * @param salBean
	 * @return
	 */
	PageBean findByCondition(SalaryBean salBean, String start, String limit);
	/**
	 * 按id查询
	 * @param salId
	 * @return
	 */
	List<Salary> findById(int salId);
	/**
	 * 按员工工号查询
	 * @param empId
	 * @return
	 */
	List<Salary> findByEmp(String empId);
	List<Salary> findAll();
	/**
	 * 按条件查询
	 * @param empId
	 * @param year
	 * @param month
	 * @return
	 */
	List<Salary> findByCondition(String empId, String year, String month);
	
	boolean unique(String empId, String year, String month);
	boolean delete(String[] salIds);

}
