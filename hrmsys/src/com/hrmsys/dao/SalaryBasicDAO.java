package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.SalaryBasicBean;
import com.hrmsys.model.SalaryBasic;

public interface SalaryBasicDAO {
	/**
	 * 查询全部
	 * @return
	 */
	List<SalaryBasic> findAll();
	/**
	 * 按员工号查询
	 * @param empId
	 * @return
	 */
	SalaryBasic findByEmpId(String empId);
	/**
	 * 按条件查询
	 * @param salBasicBean
	 * @return
	 */
	PageBean findByCondition(SalaryBasicBean salBasicBean, String start, String limit);
	/**
	 * 删除 
	 * @param sbIds
	 * @return
	 */
	boolean deleteById(String[] sbIds);
	/**
	 * 保存或修改
	 * @param salBasic
	 * @return
	 */
	boolean saveOrUpdate(SalaryBasic salBasic);
	/**
	 * 分页查询全部
	 * @param start
	 * @param limit
	 * @return
	 */
	PageBean findAll(String start, String limit);
	/**
	 * 修改
	 * @param salBasic
	 * @return
	 */
	boolean update(SalaryBasic salBasic);
	/**
	 * 保存
	 * @param salBasic
	 * @return
	 */
	boolean save(SalaryBasic salBasic);
	/**
	 * 唯一性验证
	 * true唯一
	 * @param empId
	 * @return
	 */
	boolean uniqueEmp(String empId);

}
