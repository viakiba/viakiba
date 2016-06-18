package haust.vk.dao;

import haust.vk.entity.Employee;

import java.util.List;

/**
 * 数据访问层的接口
 * @author vk
 *
 * 2016年6月18日
 */
public interface IEmployeeDao {
	/**
	 * 查询全部员工
	 */
	List<Employee> getAll();
	
	/**
	 * 根据主键查询
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
