package haust.vk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import haust.vk.dao.IEmployeeDao;
import haust.vk.entity.Employee;
import haust.vk.utils.JdbcUtils;
import haust.vk.utils.PageBean;

/**
 * @author vk
 *
 * 2016年4月15日
 */
public class EmployeeDao implements IEmployeeDao{
	/* (non-Javadoc)
	 * @see haust.vk.dao.IEmployeeDao#getAll(haust.vk.utils.PageBean)
	 */
	@Override
	public void getAll(PageBean<Employee> pb) {
		//查询总记录数；	设置到pb对象中
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		/*
		 * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
		 *            如果当前页为末页，再点下一页显示有问题！
		 * 解决：
		 * 	   1. 如果当前页 <= 0;       当前页设置当前页为1;
		 * 	   2. 如果当前页 > 最大页数；  当前页设置为最大页数
		 */
		// 判断
		if(pb.getCurrentPage()<=0){
			pb.setCurrentpage(1);
		}else if(pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentpage(pb.getTotalCount());
		}
		
		//1.获取当前页：计算查询的起始行，返回的行数
		int currentPage = pb.getCurrentPage();
		int index = (currentPage-1)*pb.getPageCount();
		int count=pb.getPageCount();
		
		//分页查询数据：把查询的数据设置到pb对象中
		String sql="select * from employee limit ?,?";
		
		try {
			QueryRunner qr=new JdbcUtils().getQueryRuner();
			List<Employee> pageData=qr.query(sql, new BeanListHandler<Employee>(Employee.class),index,count);
			pb.setPageData(pageData);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int getTotalCount() {
		String sql="select count(*) from employee";
		
		try {
			QueryRunner qr=new JdbcUtils().getQueryRuner();
			Long count=qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
