package c_prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import util.JdbcUtil;

public class Demo1 {
	
	/*
	 * 增加
	 */
	
			
	@Test
	public void test1(){
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			
			conn=JdbcUtil.getConnection();
			
			String sql="INSERT INTO test1(name) VALUES(?)";
			
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, "wangwu");
			
			int count=stmt.executeUpdate();
			
			System.out.println(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
	
	/**
	 * 修改
	 */
	@Test
	public void testUpdate() {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try{
			conn=JdbcUtil.getConnection();
			
			String sql="UPDATE test1 SET NAME=? WHERE id=?";
			
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, "haha");
			stmt.setString(2,"2");
			
			int count=stmt.executeUpdate();
			System.out.println(count);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
	
	/**
	 * 删除
	 */
	@Test
	public void testDelete() {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try{
			conn=JdbcUtil.getConnection();
			
			String sql="DELETE FROM test1 WHERE id=?";
			
			stmt=conn.prepareStatement(sql);
			
			stmt.setInt(1,3);
			
			int count=stmt.executeUpdate();
			System.out.println(count);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
	
	/**
	 * 查询
	 */
	@Test
	public void testQuery() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try{
			conn=JdbcUtil.getConnection();
			
			String sql="SELECT * FROM test1";
			
			stmt=conn.prepareStatement(sql);
			
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				
				System.out.println("id="+id+"----"+"name="+name);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}

}
