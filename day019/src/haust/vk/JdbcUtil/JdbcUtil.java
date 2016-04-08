package haust.vk.JdbcUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;


public class JdbcUtil {
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public static Connection getConnection(){
		String url="";
		String user="";
		String password="";
		
		try {
			Properties pt=new Properties();
			FileInputStream in;
			
			in = new FileInputStream(new File("./src/db.properties"));
			pt.load(in);
			
			url=pt.getProperty("url");
			user=pt.getProperty("user");
			password=pt.getProperty("password");		
			
			Connection conn=DriverManager.getConnection(url,user,password);			
			//System.out.println(conn);
			return conn;	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}
	

	public static void closeAll(Statement stmt,Connection conn,ResultSet rs){
			if(rs!=null){
				try {
					rs.close();
					rs=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(stmt!=null){
				try {
				stmt.close();
				}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}			}
			
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
