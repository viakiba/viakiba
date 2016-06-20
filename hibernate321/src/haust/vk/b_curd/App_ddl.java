package haust.vk.b_curd;

import static org.junit.Assert.*;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
 * @author vk
 *
 * 2016年6月19日
 */
public class App_ddl {
	@Test
	public void testCretae() throws Exception {
		//创建配置管理类对象
		Configuration config = new Configuration();
		//加载住配置文件
		config.configure();
		//创建工具类对象
		SchemaExport export = new SchemaExport(config);
		//建表
		//第一个参数：是否在控制台打印建表语句
		//第二个参数：是否执行脚本
		export.create(true, true);
	}
}
