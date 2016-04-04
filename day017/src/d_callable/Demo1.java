package d_callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import util.JdbcUtil;

/**
 * 使用CablleStatement调用存储过程
 * @author APPle
 *
 */

public class Demo1 {
	/**
	 * 调用带有输入参数的存储过程
	 * CALL pro_findById(4);
	 */
	@Test
	public void test1(){
		Connection conn=null;
		CallableStatement stmt=null;
		ResultSet rs=null;
		try {
			conn=JdbcUtil.getConnection();
			
			String sql="call pro_findById1(?)";
			
			stmt=conn.prepareCall(sql);
			
			stmt.setInt(1, 2);
			
			rs=stmt.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				System.out.println(id+","+name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(stmt, conn, rs);
		}
		
		
		
		
	}
	
	/**
	 * 执行带有输出参数的存储过程
	 * CALL pro_findById2(5,@NAME);
	 */
	@Test
	public void test2(){
		Connection conn=null;
		CallableStatement stmt=null;
		ResultSet rs=null;
		try {
			conn=JdbcUtil.getConnection();
			
			String sql="call pro_findById3(?,?)";
			
			stmt=conn.prepareCall(sql);
			
			stmt.setInt(1,2);
			
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			
			stmt.executeQuery();
			
			String result=stmt.getString(2);
			
			System.out.println(result);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(stmt, conn, rs);
		}
	}
}
