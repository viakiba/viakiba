package haust.vk.dao.impl;

import haust.vk.dao.IEmployeeDao;
import haust.vk.entity.Employee;
import haust.vk.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * @author vk
 *
 * 2016年4月22日
 */
public class EmployeeDao implements IEmployeeDao{
	public List<Employee> getAll(){
		try {
			String sql="";
			return JdbcUtils.getQueryRuner().query(sql, new BeanListHandler<Employee>(Employee.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
				
	}

}
