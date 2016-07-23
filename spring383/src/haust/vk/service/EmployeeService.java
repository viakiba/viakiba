package haust.vk.service;

import java.io.Serializable;

import haust.vk.dao.EmployeeDao;
import haust.vk.entity.Employee;

public class EmployeeService {
	private EmployeeDao empDao;
	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}
	public Employee save(Serializable id){
		Employee emp=empDao.findById(id);
		return emp;
	}
}
