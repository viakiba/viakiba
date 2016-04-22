package haust.vk.service.impl;
import java.util.List;

import haust.vk.dao.IEmployeeDao;
import haust.vk.dao.impl.EmployeeDao;
import haust.vk.entity.Employee;
import haust.vk.service.IEmployeeService;


/**
 * @author vk
 *
 * 2016年4月22日
 */
public class EmployeeService implements IEmployeeService {
	private IEmployeeDao e=new EmployeeDao();
	public List<Employee> getAll() {
		
		try {
			return e.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
