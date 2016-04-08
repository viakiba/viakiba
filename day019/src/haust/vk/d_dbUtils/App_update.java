package haust.vk.d_dbUtils;

import haust.vk.JdbcUtil.JdbcUtil;
import haust.vk.c_jdbc.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;

public class App_update {
	private Connection conn=null;
	
	@Test
	public void testQuery() throws Exception {
		String sql="select * from admin where id=?";
		
		conn=JdbcUtil.getConnection();
		//创建dbutils核心工具类对象
		QueryRunner qr=new QueryRunner();
		//查询
		Admin admin=qr.query(conn, sql, new ResultSetHandler<Admin>(){

			@Override
			public Admin handle(ResultSet rs) throws SQLException {
				if(rs.next()){
					Admin admin=new Admin();
					admin.setId(rs.getInt("id"));
					admin.setUserName(rs.getString("userName"));
					admin.setPwd(rs.getString("pwd"));
					
					return admin;
				}
				return null;
			}
		},1 );
		
		System.out.println(admin);
		
		conn.close();
		
	}
	
	
	//查询，使用组件提供的结果集对象封装数据
	
	//1)BeanHandler:查询返回单个对象
	
	@Test
	public void testQueryOne() throws Exception {
		String sql="select * from admin where id=?";
		
		conn=JdbcUtil.getConnection();
		//创建dbutils核心工具类对象
		QueryRunner qr=new QueryRunner();
		//查询
		Admin admin=qr.query(conn,sql, new BeanHandler<Admin>(Admin.class), 1);
		
		System.out.println(admin);
		conn.close();
	}
	@Test
	//2)BeanListHandler: 查询返回list集合，集合 元素是指定的对象
	public void testQueryMany() throws Exception{
		String sql = "select * from admin";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		// 查询全部数据
		List<Admin> list = qr.query(conn, sql, new BeanListHandler<Admin>(Admin.class));
		
		System.out.println(list);
		
		conn.close();
	}
	
/*	3) ArrayHandler, 查询返回结果记录的第一行，封装对对象数组, 即返回：Object[]
	4) ArrayListHandler, 把查询的每一行都封装为对象数组，再添加到list集合中
	5) ScalarHandler 查询返回结果记录的第一行的第一列  (在聚合函数统计的时候用)
	6) MapHandler  查询返回结果的第一条记录封装为map*/
	//
	@Test
	public void testArray() throws Exception{
		String sql = "select * from admin";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		// 查询
		Map<String, Object> map=qr.query(conn, sql,new MapHandler());
		System.out.println(map.values());
		conn.close();
	}
}
