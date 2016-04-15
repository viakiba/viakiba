package haust.vk.service;

import haust.vk.entity.Employee;
import haust.vk.utils.PageBean;

/**
 * @author vk
 *
 * 2016年4月15日
 */
public interface IEmployeeService {
	/*
	 * 业务逻辑接口层
	 */
	public void getAll(PageBean<Employee> pb);
}
