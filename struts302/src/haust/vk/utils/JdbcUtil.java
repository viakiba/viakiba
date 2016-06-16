package haust.vk.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author vk
 *
 * 2016年6月16日
 */
public class JdbcUtil {
	public static DataSource dataSource;
	
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static QueryRunner getQureyRunner(){
		return new QueryRunner(dataSource);
	}
}
