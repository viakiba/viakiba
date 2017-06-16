package com.hrmsys.dao.impl;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.SalaryBean;
import com.hrmsys.dao.SalaryDAO;
import com.hrmsys.model.Job;
import com.hrmsys.model.Salary;
import com.hrmsys.util.ConditionValidate;



public class SalaryDAOImpl extends BaseDAO implements SalaryDAO {

	@Override
	public boolean saveOrUpdate(Salary salary) {
		if(super.saveOrUpdate(salary)) 
			return true;
		return false;
	}

	@Override
	public PageBean findAll(String start, String limit) {
		String hql = "FROM Salary";
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(hql, Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findTotal(Salary.class));
		return pageBean;
	}

	@Override
	public PageBean findByCondition(SalaryBean salBean, String start, String limit) {
		StringBuffer sb = new StringBuffer("FROM Salary WHERE 1 = 1 ");
		if(ConditionValidate.isEmpty(salBean.getEmpId())){
			sb.append(" AND employee.empId='"+salBean.getEmpId()+"' ");
		}
		if(ConditionValidate.isEmpty(salBean.getEmpName())){
			sb.append(" AND employee.empName='"+salBean.getEmpName()+"' ");
		}
		if(ConditionValidate.isEmpty(salBean.getSalMonth()) && salBean.getSalMonth() > 0 && salBean.getSalMonth() < 13){
			sb.append(" AND salMonth="+salBean.getSalMonth());
		}
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(sb.toString(), Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findByHQL(sb.toString()).size());
		return pageBean;
	}

	@Override
	public List<Salary> findById(int salId) {
		return super.findByProperty(Salary.class, "salId", salId);
	}

	@Override
	public List<Salary> findByEmp(String empId) {
		String hql = "FROM Salary WHERE employee.empId=?";
		return this.findByHQLAndValue(hql, new String[]{empId});
	}

	@Override
	public List<Salary> findAll() {
		return this.findAll(Salary.class);
	}

	@Override
	public List<Salary> findByCondition(String empId, String year, String month) {
		StringBuffer sb = new StringBuffer("FROM Salary WHERE 1 = 1 ");
		if(ConditionValidate.isEmpty(empId)){
			sb.append(" AND employee.empId='"+empId+"' ");
		}
		if(ConditionValidate.isEmpty(year)){
			sb.append(" AND salYear='"+year+"' ");
		}
		if(ConditionValidate.isEmpty(month)){
			sb.append(" AND salMonth="+Integer.parseInt(month));
		}
		return this.findByHQL(sb.toString());
	}

	@Override
	public boolean unique(String empId, String year, String month) {
		String hql = "FROM Salary s WHERE s.employee.empId = ? AND s.salYear = ? AND s.salMonth = ?";
		List<Salary> sals = this.findByHQLAndValue(hql, empId, year, Integer.parseInt(month));
		if(sals.size() > 0){
			return false;
		}
		return true;
	}

	public boolean delete(String[] salIds) {
		boolean flag = true;
		for(String salId : salIds){
			if(!super.deleteById(Salary.class, Integer.parseInt(salId)))
				flag = false;
		}
		return flag;
	}
	

}