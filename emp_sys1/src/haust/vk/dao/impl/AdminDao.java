package haust.vk.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import haust.vk.dao.IAdminDao;
import haust.vk.entity.Admin;
import haust.vk.utils.JdbcUtils;

/**
 * @author vk
 *
 * 2016年4月22日
 */
public class AdminDao implements IAdminDao{
	public Admin findByNameAndPwd(Admin admin){
		try {
			String sql="select * from admin where userName=? and pwd=?";
			return JdbcUtils.getQueryRuner().query(sql, new BeanHandler<Admin>(Admin.class),admin.getUserName(),admin.getPwd());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
