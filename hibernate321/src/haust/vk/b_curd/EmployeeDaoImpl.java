package haust.vk.b_curd;

import haust.vk.a_hello.Employee;

import java.io.Serializable;
import java.util.List;


/**
 * @author vk
 *
 * 2016年6月19日
 */
public interface EmployeeDaoImpl {
	void save(Employee emp);
	void update(Employee emp);
	Employee findById(Serializable id);
	List<Employee> getAll();
	List<Employee> getAll(String employeeName);
	List<Employee> getAll(int index, int count);
	void delete(Serializable id);
}
