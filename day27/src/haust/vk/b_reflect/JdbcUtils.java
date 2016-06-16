package haust.vk.b_reflect;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author vk
 *
 * 2016年5月11日
 */
public class JdbcUtils {
	//使用c3p0工具包
	
	//先配置c3p0的配置文件桑在src文件夹的下面
	//初始化连接池
	
	private static DataSource dataSource;
	//
	static {
		dataSource=new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static QueryRunner getQuerrRunner(){
		return new QueryRunner(dataSource);
	}
	
	
}
