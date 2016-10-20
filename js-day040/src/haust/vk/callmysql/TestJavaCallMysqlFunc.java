package haust.vk.callmysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;


public class TestJavaCallMysqlFunc {
	public static void main(String[] args) throws Exception{
		String  sql = "{? = call hello(?)}";

		Connection conn = JdbcUtil.getConnection();
		CallableStatement cstmt = conn.prepareCall(sql);
		
		//第一个输出的?设置类型
		cstmt.registerOutParameter(1,Types.VARCHAR);
		
		//第二个输入的?设置值
		cstmt.setString(2,"赵君");
		
		//调用函数
		cstmt.execute();
		
		//接收返回的值
		String value = cstmt.getString(1);
		
		//显示
		System.out.println(value);
		
		JdbcUtil.close(cstmt);
		JdbcUtil.close(conn);
	}
}

