package c_prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import util.JdbcUtil;

public class Demo2 {
	/*
	 * 增加
	 */
	
			
	@Test
	public void test1(){
		String user="a";
		String password="123456";
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			
			conn=JdbcUtil.getConnection();
			
			String sql="select * from users where name='"+user+"' and password='"+password+"'";
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			if(rs.next()){
				System.out.println("登陆成功");
			}else{
				System.out.println("登陆失败");
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			
			JdbcUtil.close(stmt,conn,rs);
		}
	}
	
	
}
