package com.hrmsys.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.hrmsys.bean.EmployeeBean;
import com.hrmsys.model.Department;
import com.hrmsys.model.Employee;

public interface EmpService {
	/**
	 * 按部门编号查询部门总人数
	 * @param deptId
	 * @return
	 */
	int findNumByDept(Department dept);
	/**
	 * 获取所有员工信息
	 * @return 以json形式返回
	 */
	String getAll(String start, String limit);
	/**
	 * 按部门获取员工信息
	 * @return 以json形式返回
	 */
	String findByDeptId(String deptId);
	/**
	 * 按条件查询员工表
	 * @param deptId 部门ID
	 * @param condition 查询条目
	 * @param conditionValue 查询内容
	 * @return 返回Json.toString()
	 */
	String getByHQL(String deptId, String condition, String conditionValue, String start, String limit);
	/**
	 * 保存员工信息
	 * @param emp
	 */
	String save(Employee emp);
	/**
	 * 图片上传处理
	 * @param savePath 保存的位置
	 * @param upload 上传的文件
	 * @return msg返回结果
	 */
	String uploadPhoto(String savePath, File upload);
	/**
	 * 判断员工是否存在
	 * @param empId
	 * @return
	 */
	String isExistByEmpId(String empId);
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	String delete(String ids, String filePath);
	/**
	 * 按empId查询
	 * @param empId
	 * @return
	 */
	String listByEmpId(String empId);
	
	/**
	 * 导员工pdf信息
	 * @param empId
	 */
	void pdfExport(String empId, HttpServletResponse response, String filename, String jasper);
	List<EmployeeBean> getEmpList(String empId);
	/**
	 * 导出Excel
	 * @param response
	 * @param string
	 * @param string2
	 */
	void xlsExport(HttpServletResponse response, String filename);
	
	String unique(String empId);
}
