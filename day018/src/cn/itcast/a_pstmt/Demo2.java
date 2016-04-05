package cn.itcast.a_pstmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.utils.JdbcUtils;



public class Demo2 {
	private CallableStatement cstmt=null;
	private Connection conn=null;
	ResultSet rs=null;
	private Statement stmt=null;
	private PreparedStatement pstmt=null;
	
	@Test
	public void test1(){
		try {
			String user="lisi";
			String password="123456";
			
			
			conn=JdbcUtils.getConnection();
			
			cstmt=conn.prepareCall("call pro()");
			
			rs=cstmt.executeQuery();
			
			while(rs.next()){
				int name=rs.getInt("password");
				System.out.println("password="+name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.close(conn, cstmt, rs);
		}
	}
	
	
}
