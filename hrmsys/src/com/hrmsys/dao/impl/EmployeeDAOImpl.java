package com.hrmsys.dao.impl;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.EmployeeDAO;
import com.hrmsys.model.Department;
import com.hrmsys.model.Employee;


public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO{
	
	public List<Employee> findByDept(Department dept){
		List<Employee> emps = this.findByProperty(Employee.class, "department", dept);
		return emps;
	}

	@Override
	public List<Employee> findAll(int start, int limit) {
		String hql = "FROM Employee";
		return this.page(hql, start, limit);
	}

	@Override
	public PageBean findByHQL(String dept, String condition,
			String conditionValue, int start, int limit) {
		log.info("dept="+dept+" condition="+condition+" conditionValue=" + conditionValue);
		StringBuffer hql = new StringBuffer("FROM Employee e WHERE 1 = 1 ");
		//若deptId为0，即是查询所有部门
		if(dept != null && !"".equals(dept) && Integer.parseInt(dept) != 0){
			hql.append(" AND e.department.deptId = "+ Integer.parseInt(dept));
		}
		if(condition != null && !"".equals(condition) && conditionValue != null && !"".equals(conditionValue)){
			hql.append(" AND " + condition + " = '" + conditionValue+"'");
		}
		log.info("hql==" + hql.toString());
		PageBean pageBean = new PageBean();
		pageBean.setRoot(page(hql.toString(), start, limit));
		pageBean.setTotalProperty( this.findByHQL(hql.toString()).size());
		return pageBean;
	}

	@Override
	public boolean save(Employee emp) {
		if(super.save(emp))
			return true;
		return false;
	}

	@Override
	public Employee findByEmpId(String empId) {
		List<Employee> emps = super.findByProperty(Employee.class, "empId", empId);
		if(emps.size() > 0)
			return emps.get(0);
		else return null;
	}

	@Override
	public boolean deleteByEmpId(String[] empIds) {
		boolean flag = true;
		for(String empId : empIds){
			if(!super.deleteById(Employee.class, empId)){
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public boolean saveOrUpdate(Employee emp) {
		if(super.saveOrUpdate(emp))
			return true;
		return false;
	}

	@Override
	public boolean update(Employee emp) {
		return super.update(emp);
	}
}