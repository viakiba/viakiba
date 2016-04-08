package haust.vk.d_dbUtils;

import haust.vk.JdbcUtil.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;


public class App_query {
	private Connection conn=null;
	
	//更新
	@Test
	public void testUpdate() throws Exception{
		String sql = "delete from admin where id=?";
		// 连接对象
		conn = JdbcUtil.getConnection();

		// 创建DbUtils核心工具类对象
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, 3);
		
		conn.close();
	}
	
	//批处理
	@Test
	public void testBatch() throws Exception {
		String sql = "insert into admin (userName, pwd) values(?,?)";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		qr.batch(conn, sql, new Object[][]{{"jack1","888"},{"jack2","999"}});
	}
}
