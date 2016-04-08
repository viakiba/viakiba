package haust.vk.b_metadata;

import haust.vk.JdbcUtil.JdbcUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

public class App {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	//数据库元数据
	@Test
	public void test1(){
		conn=JdbcUtil.getConnection();
		
		try {
			DatabaseMetaData metaData = conn.getMetaData();
			System.out.println(metaData.getURL());
			System.out.println(metaData.getUserName());
			System.out.println(metaData.getDatabaseProductName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2. 参数元数据
	@Test
	public void test2() {
		try {
			conn=JdbcUtil.getConnection();
			
			String sql="select * from test1 where id=?;";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, 2);
			//得到参数元数据的获取对象
			ParameterMetaData p_metaData =	pstmt.getParameterMetaData();
			//获取参数元数据的个数
			int count=p_metaData.getParameterCount();
			//测试
			System.out.println(count);
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.closeAll(null, conn, null);
		}
	}
	
	//获取参数的对应值
	@Test
	public void test3(){
		try {
			conn=JdbcUtil.getConnection();
			String sql="select * from test1 where id=?;";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, 2);
			rs=pstmt.executeQuery();
			
			ResultSetMetaData rs_metaData = rs.getMetaData();
			
			while(rs.next()){
				int count = rs_metaData.getColumnCount();
				
				for(int i=0;i<count;i++){
					
					String id=rs_metaData.getColumnName(i+1);
					Object value=rs.getObject(id);
					
					System.out.println(id+"="+value);
				}
				System.out.println("结束 ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.closeAll(null, conn, rs);
		}
	}
}
