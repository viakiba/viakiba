package com.hrmsys.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.hrmsys.bean.SalaryBean;
import com.hrmsys.model.Salary;

public interface SalaryService {
	/**
	 * 依据员工号提取数据
	 * @param empId
	 * @return json
	 */
	String distill(String empId);
	/**
	 * 计算个人税
	 * @param allMoney
	 * @return
	 */
	float caculate(String allMoney);
	/**
	 * 保存
	 * @param salary
	 * @return
	 */
	String save(Salary salary);
	/**
	 * 查询所有
	 * @return
	 */
	String list(String start, String limit);
	/**
	 * 条件查询
	 * @param salBean
	 * @return
	 */
	String getListByCondition(SalaryBean salBean, String start, String limit);
	/**
	 * 按id查询
	 * @param salId
	 * @return
	 */
	String getSalById(String salId);
	/**
	 * 查询清单
	 * @param empId
	 * @return
	 */
	List<SalaryBean> getSalary(String empId, String year, String month);
	/**
	 * 导出pdf
	 * @param response
	 * @param empId
	 * @param year
	 * @param month
	 */
	void export(HttpServletResponse response, String empId, String year,
			String month);
	/**
	 * 判断工资是否已生成
	 * @param empId
	 * @param substring
	 * @param month
	 * @return
	 */
	boolean unique(String empId, String substring, String month);
	String delete(String ids);

}
