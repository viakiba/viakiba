package haust.vk.service;

import haust.vk.entity.Employee;

import java.util.List;

/**
 * @author vk
 *
 * 2016年6月18日
 */
public interface IEmployeeService {
	/**
	 * 查询全部员工
	 */
	List<Employee> list();
	
	/**
	 * 根据id进行查询
	 */
	Employee findById(int id);
	
	/**
	 * 添加员工
	 */
	void save(Employee emp);
	
	/**
	 * 修改员工
	 */
	void update(Employee emp);
}
