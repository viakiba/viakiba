package haust.vk.service.impl;

import java.util.List;

import haust.vk.dao.IEmployeeDao;
import haust.vk.dao.impl.EmployeeDao;
import haust.vk.entity.Employee;
import haust.vk.service.IEmployeeService;

/**
 * @author vk
 *
 * 2016年6月18日
 */
public class EmployeeService implements IEmployeeService{
	private IEmployeeDao employeeDao = new EmployeeDao();
	
	@Override
	public List<Employee> list() {
		try {
			return employeeDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Employee findById(int id) {
		try {
			return employeeDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(Employee emp) {
		try {
			employeeDao.save(emp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(Employee emp) {
		try {
			employeeDao.update(emp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
