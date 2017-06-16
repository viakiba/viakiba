package com.hrmsys.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.DepartmentDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.Department;
import com.hrmsys.service.DeptService;
import com.hrmsys.service.EmpService;

public class DeptServiceImpl implements DeptService {
	private DepartmentDAO deptDAO;
	private EmpService empService;

	@Override
	public String getAll() {
		List<Department> depts = deptDAO.findAll(Department.class);
		return JSONArray.fromObject(depts).toString();
	}

	@Override
	public String getAll(String start, String limit) {
		List<Department> depts = deptDAO.findAllDept(start, limit);
		for (Department dept : depts) {
			int num = empService.findNumByDept(dept);
			dept.setDeptNum(num);
		}
		String root = JSONArray.fromObject(depts).toString();
		int totalProperty = deptDAO.findTotal(Department.class);
		return "{totalProperty:" + totalProperty + ",root:" + root + "}";
	}

	@Override
	public String delete(String ids) {
		String[] deptIds = ids.split(",");
		if (deptDAO.delete(deptIds)) {
			return StaticValue.DELETE_SUCCESS;
		}
		return StaticValue.DELETE_FAILURE;
	}

	@Override
	public String save(Department dept) {
		if (deptDAO.saveOrUpdate(dept)) {
			return StaticValue.SAVE_SUCCESS;
		}
		return StaticValue.SAVE_FAILURE;
	}

	@Override
	public String getDeptByCondition(String condition, String conditionValue,
			String start, String limit) {
		PageBean pageBean = deptDAO.findDeptByCondition(condition,
				conditionValue, Integer.parseInt(start), Integer
						.parseInt(limit));
		List<Department> depts = pageBean.getRoot();
		for (Department dept : depts) {
			int num = empService.findNumByDept(dept);
			dept.setDeptNum(num);
		}
		pageBean.setRoot(depts);
		JSONArray jsonDept = JSONArray.fromObject(pageBean.getRoot());
		return "{totalProperty:" + pageBean.getTotalProperty() + ",root:"
				+ jsonDept.toString() + "}";
	}

	@Override
	public String listById(String deptId) {
		List<Department> depts = deptDAO.findById(deptId);
		return JSONArray.fromObject(depts).toString();
	}

	@Override
	public String getReportDate() {
		List<Department> depts = deptDAO.findAll(Department.class);
		byte[] utf8Bom = new byte[] { (byte) 0xef, (byte) 0xbb, (byte) 0xbf };
		String deptXML = "";
		try {
			// 定义BOM标记 ,若无则无法显示中文,页面报invalidate xml data错误
			deptXML = new String(utf8Bom, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		deptXML += "<?xml version='1.0' encoding='UTF-8'?><chart caption='部门人数统计'"
				+ " xAxisName='部门' yAxisName='人数' bgColor='#dfe8f6;' showValues='1'  "
				+ "canvasBgColor='#dfe8f6;' baseFontSize='13' decimals='0' animation='1' "
				+ "formatNumberScale='0' exportEnabled='1' exportAtClient='1' exportHandler='jsp/report/fcExporter.jsp'>";
		for (Department dept : depts) {
			int num = empService.findNumByDept(dept);
			deptXML += "<set label='" + dept.getDeptName() + "' value='" + num
					+ "' />";
		}
		deptXML += "</chart>";
		String deptXMLStr = deptXML.toString();
		return deptXML.toString();
	}

	/** getter and setter method **/
	public DepartmentDAO getDeptDAO() {
		return deptDAO;
	}

	public void setDeptDAO(DepartmentDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

}
