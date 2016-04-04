package b_statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.JdbcUtil;

public class Demo3 {
	private static String url="jdbc:mysql://localhost:3306/test2";
	private static String user="root";
	private static String paaaword="password";
/*
 * 	查询操作
 */
	Connection conn=null;
	Statement stat=null;
	@Test
	public void test1(){
		try {
		
		conn=JdbcUtil.getConnection();
				
		stat=conn.createStatement();
		
		String sql="select * from test1";
		ResultSet rs=stat.executeQuery(sql);
		boolean flag=rs.next();
		if(flag==true){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			System.out.println("id="+id+"--name="+name);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stat, conn);
		}
		
	}
	
	
}
