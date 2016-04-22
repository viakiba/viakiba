package haust.vk.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import haust.vk.entity.Admin;
import haust.vk.utils.JdbcUtils;

/**
 * @author vk
 *
 * 2016年4月22日
 */
public interface IAdminDao {
	public Admin findByNameAndPwd(Admin admin);
}
