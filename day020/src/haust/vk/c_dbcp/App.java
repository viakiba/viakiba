package haust.vk.c_dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class App {
	//硬编码实现连接池
	@Test
	public void testDbcp() throws Exception{
		//dbcp连接池类
		BasicDataSource dataSouce=new BasicDataSource();
		dataSouce.setUrl("jdbc:mysql:///jdbc_demo");
		dataSouce.setDriverClassName("com.mysql.jdbc.Driver");
		dataSouce.setUsername("root");
		dataSouce.setPassword("root");
		dataSouce.setInitialSize(3);
		dataSouce.setMaxActive(6);
		dataSouce.setMaxIdle(3000);
		
		//获取连接
		Connection con=dataSouce.getConnection();
		
		int count = con.prepareStatement("delete from admin where id=2").executeUpdate();
		System.out.println(count);
		con.close();
	}
	
	//properties配置文件
	@Test
	public void testDbcp1() throws Exception{
		Properties pr=new Properties();
		InputStream file=App.class.getResourceAsStream("db.properties");
		pr.load(file);
		
		DataSource data=BasicDataSourceFactory.createDataSource(pr);
		
		//
		Connection con=data.getConnection();
		con.prepareStatement("delete from admin where id=1").executeUpdate();
		con.close();
	}
}
