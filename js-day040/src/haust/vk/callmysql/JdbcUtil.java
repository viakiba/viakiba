package haust.vk.callmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/js";
	private static String user = "root";
	private static String password = "root";
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url,user,password);
	}
	
	public static void close(Connection conn) throws Exception{
		if(conn != null){
			conn.close();
		}
	}
	public static void close(Statement stmt) throws Exception{
		if(stmt != null){
			stmt.close();
		}
	}
	public static void close(ResultSet rs) throws Exception{
		if(rs != null){
			rs.close();
		}
	}
}




