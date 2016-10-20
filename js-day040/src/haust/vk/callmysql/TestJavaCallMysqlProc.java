package haust.vk.callmysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;


public class TestJavaCallMysqlProc {
	public static void main(String[] args) throws Exception{
		//Java调用过程的语法，这里只有一个?号，它是输出值
		String  sql = "{call simpleproc(?)}";

		Connection conn = JdbcUtil.getConnection();
		CallableStatement cstmt = conn.prepareCall(sql);
		
		//这个输出的?设置类型，?号下标从1开始
		cstmt.registerOutParameter(1,Types.INTEGER);

		//执行过程的调用
		cstmt.execute();
		
		//接收过程的返回值
		Integer count = cstmt.getInt(1);
		
		//显示
		System.out.println("共有" + count + "个用户");
		
		
		JdbcUtil.close(cstmt);
		JdbcUtil.close(conn);
	}
}
