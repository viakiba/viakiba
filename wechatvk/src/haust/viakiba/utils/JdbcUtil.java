package haust.viakiba.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class JdbcUtil {
	public static Connection getConnection() throws Exception{
		Driver driver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wechatvk", "root", "password");
		return conn;
	}
}
