package haust.vk.XMLUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author vk
 *
 * 2016年4月22日
 */
public class JdbcUtil {
	private static String url="jdbc:mysql:///jdbc_demo";
	private static String user="root";
	private static String password="root";
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void closeAll(Connection con,Statement stmt,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
			
			if(con!=null){
				con.close();
				con=null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
