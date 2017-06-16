package com.hrmsys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.SalaryBean;
import com.hrmsys.dao.BoonDAO;
import com.hrmsys.dao.DepartmentDAO;
import com.hrmsys.dao.EmployeeDAO;
import com.hrmsys.dao.RevenueDAO;
import com.hrmsys.dao.SalaryBasicDAO;
import com.hrmsys.dao.SalaryDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.Boon;
import com.hrmsys.model.Employee;
import com.hrmsys.model.Revenue;
import com.hrmsys.model.Salary;
import com.hrmsys.model.SalaryBasic;
import com.hrmsys.service.SalaryService;
import com.hrmsys.util.FileExport;

public class SalaryServiceImpl implements SalaryService{
	private SalaryDAO salaryDAO;
	private DepartmentDAO deptDAO;
	private SalaryBasicDAO salBasicDAO;
	private RevenueDAO revenueDAO;
	private BoonDAO boonDAO;
	private EmployeeDAO empDAO;

	@Override
	public String distill(String empId) {
		Employee emp =  empDAO.findByEmpId(empId);
		SalaryBean salaryBean = new SalaryBean();
		if(emp != null){
			salaryBean.setEmpId(emp.getEmpId());
			salaryBean.setEmpName(emp.getEmpName());
			salaryBean.setSalJob(emp.getJob().getJobBasicWage());
		}
		SalaryBasic salaryBasic = salBasicDAO.findByEmpId(empId);
		List<Boon> boons = boonDAO.findAll();
		if(salaryBasic != null){
			salaryBean.setSalBasic(salaryBasic.getSbBasic());
			if(salaryBasic.getSbEndowment()==1){
				Boon boon = boons.get(0);
				salaryBean.setSalEndowmentint(boon.getBoonMoney() * boon.getBoonPercent()/100);
			}
			if(salaryBasic.getSbHospitalization()==1){
				Boon boon = boons.get(1);
				salaryBean.setSalHospitalizationint(boon.getBoonMoney() * boon.getBoonPercent()/100);
			}
			if(salaryBasic.getSbUnemployment()==1){
				Boon boon = boons.get(2);
				salaryBean.setSalUnemploymentint(boon.getBoonMoney() * boon.getBoonPercent()/100);
			}
			salaryBean.setSalTelephone(salaryBasic.getSbTelephone());
			salaryBean.setSalTrafficfloat(salaryBasic.getSbTraffic());
			salaryBean.setSalEateryfloat(salaryBasic.getSbEatery());
		}
		//此处需返回json对象的字符串形式非数组形式
		String salaryJson = JSONObject.fromObject(salaryBean).toString();
		return salaryJson;
	}
	
	@Override
	public float caculate(String allMoney) {
		Revenue revenue = revenueDAO.findByMinAndMax(Float.parseFloat(allMoney));
		float revenueMoney = Float.parseFloat(allMoney)*revenue.getRePercent()/100-revenue.getReMinus();
		return revenueMoney;
	}
	
	@Override
	public String save(Salary salary) {
		if(salaryDAO.saveOrUpdate(salary)) 
			return StaticValue.SAVE_SUCCESS;
		return StaticValue.DELETE_FAILURE;
	}
	
	@Override
	public String list(String start, String limit) {
		PageBean pageBean = salaryDAO.findAll(start, limit);
		String json = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+json+"}";
	}
	
	@Override
	public String getListByCondition(SalaryBean salBean, String start, String limit) {
		PageBean pageBean = salaryDAO.findByCondition(salBean, start, limit);
		String json = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+json+"}";
	}
	

	@Override
	public String getSalById(String salId) {
		List<Salary> sals = salaryDAO.findById(Integer.parseInt(salId));
		if(null != sals){
			return JSONArray.fromObject(sals).toString();
		}
		return null;
	}
	
	@Override
	public List<SalaryBean> getSalary(String empId, String year, String month) {
		List<Salary> salarys = null;
			salarys = salaryDAO.findByCondition(empId, year, month);
		return packageSal(salarys);
	}
	
	@Override
	public void export(HttpServletResponse response, String empId, String year,
			String month) {
		List<Salary> salarys = salaryDAO.findByCondition(empId, year, month);
		List<SalaryBean> salaryBeans = packageSal(salarys);
		FileExport fileExport = new FileExport();
		fileExport.exportPDF(salaryBeans, "工资单","salary.jasper", response);
	}

	public List<SalaryBean> packageSal(List<Salary> salarys){
		List<SalaryBean> salBeans = new ArrayList<SalaryBean>();
		for(Salary salary : salarys){
			SalaryBean salBean = new SalaryBean();
			salBean.setSalId(salary.getSalId());
			salBean.setEmpId(salary.getEmployee().getEmpId());
			salBean.setEmpName(salary.getEmployee().getEmpName());
			salBean.setSalAbsenteeism(salary.getSalAbsenteeism());
			salBean.setSalAbsenteeismMoney(salary.getSalAbsenteeismMoney());
			salBean.setSalAll(salary.getSalAll());
			salBean.setSalAllowance(salary.getSalAllowance());
			salBean.setSalBasic(salary.getSalBasic());
			salBean.setSalEateryfloat(salary.getSalEateryfloat());
			salBean.setSalEndowmentint(salary.getSalEndowmentint());
			salBean.setSalHospitalizationint(salary.getSalHospitalizationint());
			salBean.setSalJob(salary.getSalJob());
			salBean.setSalMoney(salary.getSalMoney());
			salBean.setSalMonth(salary.getSalMonth());
			salBean.setSalNormal(salary.getSalNormal());
			salBean.setSalRevenue(salary.getSalRevenue());
			salBean.setSalTelephone(salary.getSalTelephone());
			salBean.setSalTrafficfloat(salary.getSalTrafficfloat());
			salBean.setSalUnemploymentint(salary.getSalUnemploymentint());
			salBean.setSalYear(salary.getSalYear());
			salBeans.add(salBean);
		}
		return salBeans;
	}
	@Override
	public boolean unique(String empId, String year, String month) {
		return salaryDAO.unique(empId, year, month);
	}
	@Override
	public String delete(String ids) {
		String[] salIds = ids.split(",");
		if(salaryDAO.delete(salIds)) return StaticValue.DELETE_SUCCESS;
		return StaticValue.DELETE_FAILURE;
	}
	
	/*************setter and getter**************/
	public SalaryDAO getSalaryDAO() {
		return salaryDAO;
	}

	public void setSalaryDAO(SalaryDAO salaryDAO) {
		this.salaryDAO = salaryDAO;
	}

	public DepartmentDAO getDeptDAO() {
		return deptDAO;
	}

	public void setDeptDAO(DepartmentDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

	public SalaryBasicDAO getSalBasicDAO() {
		return salBasicDAO;
	}

	public void setSalBasicDAO(SalaryBasicDAO salBasicDAO) {
		this.salBasicDAO = salBasicDAO;
	}

	public RevenueDAO getRevenueDAO() {
		return revenueDAO;
	}

	public void setRevenueDAO(RevenueDAO revenueDAO) {
		this.revenueDAO = revenueDAO;
	}

	public BoonDAO getBoonDAO() {
		return boonDAO;
	}

	public void setBoonDAO(BoonDAO boonDAO) {
		this.boonDAO = boonDAO;
	}

	public EmployeeDAO getEmpDAO() {
		return empDAO;
	}

	public void setEmpDAO(EmployeeDAO empDAO) {
		this.empDAO = empDAO;
	}

}
