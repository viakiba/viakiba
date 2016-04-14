package haust.vk.d_c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class App {
	@Test
	//硬编码实现c3p0的连接池管理
	public void test1() throws Exception{
		//创建连接池工具类
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc_demo");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setMaxIdleTime(1000);
		dataSource.setInitialPoolSize(3);
		dataSource.setMaxPoolSize(6);
		
		Connection con=dataSource.getConnection();
		con.prepareStatement("insert into admin values(1,'lisi','546454') ").executeUpdate();
		con.close();
	}
	
	//使用配置文件xml进行初始化配置
	@Test
	public void testXml() throws Exception{
		// 创建c3p0连接池核心工具类
		// 自动加载src下c3p0的配置文件【c3p0-config.xml】
		ComboPooledDataSource datasource=new ComboPooledDataSource();
		PreparedStatement pstmt=null;
		Connection con=datasource.getConnection();
		for (int i=1; i<11;i++){
			String sql = "insert into employee(empName,dept_id) values(?,?)";
			// 执行更新
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Rose" + i);
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
		}
		pstmt.close();
		// 关闭
		con.close();
	}
}
