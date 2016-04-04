package a_jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;



public class Test1 {
	private String url="jdbc:mysql://localhost:3306/test2";
	private String user="root";
	private String password="root";
	
	@Test
	public void test() throws Exception{
		//创建driver对象，用于连接数据库（驱动）
		Driver driver = new com.mysql.jdbc.Driver();
		//Driver driver =new org.gjt.mm.mysql.Driver();
		//Properties 创建一个文件，用于保存具体的使用字符串，可以方便调用
		Properties properties=new Properties();
		properties.setProperty("user", user);
		properties.setProperty("password", password);
		//创建连接对象
		Connection conn=driver.connect(url, properties);
		
		//输出连接对象id
		System.out.println(conn);
	}
	
	/*
	 * 使用驱动管理器类管理驱动程序
	 */
	@Test
	public void test1() throws Exception{
		//Driver driver=new com.mysql.jdbc.Driver();
		Class.forName("com.mysql.jdbc.Driver");
		//DriverManager.registerDriver(driver);
		
		Connection conn=DriverManager.getConnection(url, user, password);
		
		System.out.println(conn);
	}
}
