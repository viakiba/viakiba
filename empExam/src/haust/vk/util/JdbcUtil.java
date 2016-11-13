package haust.vk.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 链接sql的工具类
 * @author viakiba
 *
 */
public class JdbcUtil {
	
	/**
	 * 去src目录下加载c3p0-config.xml配置文件
	 */
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}
	

}
