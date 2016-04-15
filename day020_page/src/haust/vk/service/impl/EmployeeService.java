package haust.vk.service.impl;

import haust.vk.dao.impl.EmployeeDao;
import haust.vk.entity.Employee;
import haust.vk.service.IEmployeeService;
import haust.vk.utils.PageBean;

/**
 * @author vk
 *
 * 2016Äê4ÔÂ15ÈÕ
 */
public class EmployeeService implements IEmployeeService{
	EmployeeDao employeeDao=new EmployeeDao();
	/* (non-Javadoc)
	 * @see haust.vk.service.IEmployeeService#getAll(haust.vk.utils.PageBean)
	 */
	@Override
	public void getAll(PageBean<Employee> pb) {
		try {
			employeeDao.getAll(pb);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
