package haust.vk.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author vk
 *
 * 2016年6月18日
 */
public class JdbcUtils {
	private static  DataSource datasource;
	
	static {
		datasource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return datasource;
	}
	
	public static QueryRunner getQueryRunner(){
		return new QueryRunner(datasource);
	}
	
}
