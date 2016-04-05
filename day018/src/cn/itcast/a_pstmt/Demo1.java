package cn.itcast.a_pstmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.utils.JdbcUtils;

public class Demo1 {
	/*
	 * 这是对sql注入的一个练习，昨天也进行过学习
	 * statement无法进行有效的避免sql注入
	 * 但是具有预编译功能的preparedstatement
	 * 可以有效的防治sql注入的出现
	 */
	
	
	/*
	 * 首先声明全局变量
	 */
	private Connection conn=null;
	private Statement stmt=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private CallableStatement cstmt=null;
	
	
	
	/*
	 * 这是使用statement对于sql注入的模拟（登陆）
	 */
	@Test
	public void test1(){
		try {
			conn=JdbcUtils.getConnection();
			
			String user="lisi";
			String password=" ' or 1=1 -- ";
			
			//String sql="select * from stu where name='"+user+"' and password='"+password+"' ";
			String sql="select * from stu where name='lisi' and password=' ' or 1=1 -- ' ";
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			if(rs!=null){
				rs.next();
				System.out.println(rs.getString("name"));
				System.out.println("登陆成功");
			}else{
				System.out.println("登陆失败");
			}
			
			
			//System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.close(conn, stmt,rs);
		}
	}
	
	/*
	 * 这是使用PreparedStatement防止sql注入的模拟（登陆）
	 */
	@Test
	public void test2(){
		try {
			conn=JdbcUtils.getConnection();
			
			String user="lisi";
			String password=" ' or 1=1 -- ";
			
			String sql="select * from stu where name=? and password=?";
			//String sql="select * from stu where name='lisi' and password=' ' or 1=1 -- ' ";
							
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, user);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println("登陆成功"+rs.getInt("id"));
			}else{
				System.out.println("登陆失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.close(conn, stmt,rs);
		}
		
		
		
	}
}
