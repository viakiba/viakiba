package cn.itcast.d_tx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import cn.itcast.utils.JdbcUtils;



public class AccountDao {
	
	// 全局参数
		private Connection con;
		private PreparedStatement pstmt;
		private int count=0;
	/*
	 * 不使用事务
	 */
	
		@Test
		public void trans2(){
			String sql_zs = "UPDATE account set money=money-1000 where accountName='张三';";
			String sql_ls = "UPDATE account SET money=money+1000 WHERE accountName='李四';";
			
			try {
				con=JdbcUtils.getConnection();
				pstmt=con.prepareStatement(sql_zs);
				
				count=pstmt.executeUpdate();
				System.out.println("影响一行");
				pstmt=con.prepareStatement(sql_ls);
				count=pstmt.executeUpdate();
				System.out.println("影响一行");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				JdbcUtils.close(con, pstmt);
			}
		}
		
	/*
	 * 使用隐式事务
	 */
	@Test
	public void trans1(){
		String sql_zs = "UPDATE account SET money=money-1000 WHERE accountName='张三';";
		String sql_ls = "UPDATE account SET money=money+1000 WHERE accountName='李四1';";

		try {
			con = JdbcUtils.getConnection(); // 默认开启的隐士事务
			con.setAutoCommit(true);

			/*** 第一次执行SQL ***/
			pstmt = con.prepareStatement(sql_zs);
			count=pstmt.executeUpdate();
			System.out.println(count+"hang");
			/*** 第二次执行SQL ***/
			pstmt = con.prepareStatement(sql_ls);
			count=pstmt.executeUpdate();
			System.out.println(count+"hang");
		} catch (Exception e) {
			try {
				// 二、 出现异常，需要回滚事务
				con.rollback();
			} catch (SQLException e1) {
			}
			e.printStackTrace();
		} finally {
			try {
				// 三、所有的操作执行成功, 提交事务
				con.commit();
				JdbcUtils.close(con, pstmt, null);
			} catch (SQLException e) {
			}
		}
	}
	
	/*
	 * 使用隐式事务
	 */
	@Test
	public void trans(){
		String sql_zs = "UPDATE account SET money=money-1000 WHERE accountName='张三';";
		String sql_ls = "UPDATE account SET money=money+1000 WHERE accountName='李四1';";
		Savepoint sp=null;
		try {
			con = JdbcUtils.getConnection(); // 默认开启的隐士事务
			con.setAutoCommit(false);

			/*** 第一次执行SQL ***/
			pstmt = con.prepareStatement(sql_zs);
			count=pstmt.executeUpdate();
			System.out.println(count+"hang");
			
			sp=con.setSavepoint();
			/*** 第二次执行SQL ***/
			pstmt = con.prepareStatement(sql_ls);
			count=pstmt.executeUpdate();
			System.out.println(count+"hang");
		} catch (Exception e) {
			try {
				// 二、 出现异常，需要回滚事务
				con.rollback(sp);
			} catch (SQLException e1) {
			}
			e.printStackTrace();
		} finally {
			try {
				// 三、所有的操作执行成功, 提交事务
				con.commit();
			} catch (SQLException e) {
			}
			JdbcUtils.close(con, pstmt, null);
		}
	}
}
