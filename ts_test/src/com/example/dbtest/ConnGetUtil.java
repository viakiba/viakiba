package com.example.dbtest;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection ;

/** 
 * @description: 获取连接
 * @author viakiba
 * @date 2017年7月25日
 */
public class ConnGetUtil {
	public static Connection conn;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mmo", "mmo", "mmo0327");
			conn = DriverManager.getConnection("jdbc:mysql://10.71.56.74:3306/mmo?user=mmo&password=mmo0327&useUnicode=true&characterEncoding=utf-8");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn(){
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println(conn == null);
		System.out.println(conn.toString());
		
		PreparedStatement prepareStatement = conn.prepareStatement("select * from activity where id = 1");
		ResultSet executeQuery = prepareStatement.executeQuery();
		executeQuery.next();
		String string = executeQuery.getString(2);
		System.out.println(string);
		executeQuery.close();
		prepareStatement.close();
		conn.close();
	}
}
