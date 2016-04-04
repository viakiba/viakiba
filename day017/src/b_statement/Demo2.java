package b_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.JdbcUtil;

public class Demo2 {
		/*
		 * 使用statement执行dml语句
		 */
	String url="jdbc:mysql://localhost:3306/test2";
	String user="root";
	String password="root";
	
	Statement stat=null;
	Connection conn=null;
	/*
	 * 插入
	 */
	@Test
	public void test1(){
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接对象
			conn=DriverManager.getConnection(url, user, password);
			//创建statement对象，用于执行sql语句
			stat=conn.createStatement();
			//设置sql语句
			String sql="INSERT INTO test1(id,name) VALUE(2,'wangliu')";
			//执行sql语句
			int count=stat.executeUpdate(sql);
			System.out.println(count);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		
		
	}
	
	/*
	 * 更新
	 */
	@Test
	public void test2(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//conn=DriverManager.getConnection(url, user, password);
			conn=JdbcUtil.getConnection();
			stat=conn.createStatement();
			
			String sql="UPDATE test1 SET name='lisi' where id=2";
			
			int count=stat.executeUpdate(sql);
			System.out.println(count);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			/*if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}*/
			JdbcUtil.close(stat, conn);
		}
		
	}
	
	/*
	 * 删除
	 */
	@Test
	public void test3(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection(url, user, password);
			
			stat=conn.createStatement();
			
			String sql="DELETE FROM test1 where id=1";
			
			int count=stat.executeUpdate(sql);
			System.out.println(count);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		
	}
}
