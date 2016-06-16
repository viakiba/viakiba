package haust.vk.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import haust.vk.entity.Admin;
import haust.vk.utils.JdbcUtil;

/**
 * @author vk
 *
 * 2016年6月16日
 */
public class AdminDao {
	
	public Admin login(Admin admin){
		String sql = "select * from admin where userName=? and pwd=?";
		try {
			return JdbcUtil.getQureyRunner().query(sql, new BeanHandler<Admin>(Admin.class),admin.getUserName(),admin.getPwd());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	public List<Admin> getAll(){
		String sql = "select * from admin";
		
		try {
			return JdbcUtil.getQureyRunner().query(sql, new BeanListHandler<Admin>(Admin.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}



}
