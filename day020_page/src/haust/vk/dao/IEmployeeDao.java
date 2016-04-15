package haust.vk.dao;

import haust.vk.entity.Employee;
import haust.vk.utils.PageBean;

/**
 * @author vk
 *
 * 2016年4月15日
 */
/*
 * 数据访问层，接口设计
 */
public interface IEmployeeDao {
	/*
	 * 分页查询设计
	 */
	public void getAll(PageBean<Employee> pb);
	/*
	 * 查询总记录数
	 */
	public int getTotalCount();
}
