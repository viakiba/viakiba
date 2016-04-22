package haust.vk.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author vk
 *
 * 2016年4月22日
 */
public class JdbcUtils {
	/*
	 * 初始化c3p0连接池
	 */
	private static DataSource dataSource;
	static{
		dataSource=new ComboPooledDataSource();
	}
	
	//创建DbUtils核心工具类
	public static QueryRunner getQueryRuner(){
		return new QueryRunner(dataSource);
	}
}
