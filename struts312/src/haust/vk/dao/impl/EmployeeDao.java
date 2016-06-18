package haust.vk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import haust.vk.dao.IEmployeeDao;
import haust.vk.entity.Employee;
import haust.vk.utils.JdbcUtils;

/**
 * @author vk
 *
 * 2016年6月18日
 */
public class EmployeeDao implements IEmployeeDao{

	@Override
	public List<Employee> getAll() {
		String sql = "select * from employee";
		
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<Employee>(Employee.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Employee findById(int id) {
		String sql = "select * from Employee where id=?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<Employee>(Employee.class),id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(Employee emp) {
		String sql = "insert into employee(empName,workDate) values(?,?)";
		
		try {
			JdbcUtils.getQueryRunner().update(sql, emp.getEmpName() ,emp.getWorkDate());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public void update(Employee emp) {
		String sql = "update employee set empName=?, workDate=? where id=?";
		
		try {
			JdbcUtils.getQueryRunner().update(sql ,emp.getEmpName() ,emp.getWorkDate() ,emp.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
