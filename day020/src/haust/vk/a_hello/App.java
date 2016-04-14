package haust.vk.a_hello;

import haust.vk.utils.JdbcUtil;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

public class App {
	
	//使用DBUtil进行更新
	@Test
	public void testUpdata() throws Exception{
		String sql="delete from admin where id=3;";
		
		//创建连接
		Connection con=JdbcUtil.getConnection();
		//创建核心工具类
		QueryRunner qr=new QueryRunner();
		//更新
		qr.update(con,sql);
		//关闭
		con.close();
		
	}
	
	//使用DBUtil进行查询
	@Test
	public void testQuery() throws Exception{
		String sql="select * from admin";
		
		//创建连接
		Connection con=JdbcUtil.getConnection();
		//创建工具类
		QueryRunner qr=new QueryRunner();
		//执行sql语句
		List<Admin> list=qr.query(con, sql, new BeanListHandler<Admin>(Admin.class));
		System.out.println(list.get(1));
		con.close();
	}
}
