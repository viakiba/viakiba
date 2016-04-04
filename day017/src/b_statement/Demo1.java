package b_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo1 {
	String url="jdbc:mysql://localhost:3306/test2";
	String user="root";
	String password="root";
	
		@Test
		public void stateDemo(){
			Statement state=null;
			Connection conn=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				conn=DriverManager.getConnection(url, user, password);
				
				state=conn.createStatement();
				
				String sql="create table test1 (id int PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20))";
				
				int count=state.executeUpdate(sql);
				System.out.println(count);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				if(state!=null){
					try {
						state.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(state!=null){
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				
			}
		}
}
