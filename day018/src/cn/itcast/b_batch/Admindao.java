package cn.itcast.b_batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cn.itcast.utils.JdbcUtils;

public class Admindao {
	
	private static Connection conn=null;
	private static Statement pstmt=null;
	
	
	public static void save(List<Admin> list){
		int i=4;
		for(Admin ad : list){
			dosave(ad,i++);
		}
		
		
	}
	
	public static void dosave(Admin admin,int i){
		
		try {
			conn=JdbcUtils.getConnection();
			
			String sql="INSERT INTO stu(id,name,password) VALUES ('"+i+"','"+admin.getName()+"','"+admin.getPassword()+"')";
			
			pstmt=conn.createStatement();
			
			pstmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.close(conn, pstmt);
		}
		
	}
}
