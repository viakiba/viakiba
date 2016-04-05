package cn.itcast.e_longtext;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.utils.JdbcUtils;


public class App_text {
	// 全局参数
		private Connection con;
		private Statement stmt;
		private PreparedStatement pstmt;
		private ResultSet rs;
		

		@Test
		// 1. 保存大文本数据类型   ( 写longtext)
		public void testSaveText() {
			String sql = "insert into test(content) values(?)";
			try {
				// 连接
				con = JdbcUtils.getConnection();
				// pstmt 对象
				pstmt = con.prepareStatement(sql);
				// 设置参数
				// 先获取文件路径
				String path = App_text.class.getResource("tips.txt").getPath();
				FileReader reader = new FileReader(new File(path));
				pstmt.setCharacterStream(1, reader);
				
				// 执行sql
				pstmt.executeUpdate();
				
				// 关闭
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtils.close(con, pstmt, null);
			}
		}
		
		@Test
		// 2. 读取大文本数据类型   ( 读longtext)
		public void testGetAsText() {
			String sql = "select * from  test;";
			try {
				// 连接
				con = JdbcUtils.getConnection();
				// pstmt 对象
				pstmt = con.prepareStatement(sql);
				// 读取
				rs = pstmt.executeQuery();
				if (rs.next()) {
					// 获取长文本数据, 方式1:
					//Reader r = rs.getCharacterStream("content");
					
					// 获取长文本数据, 方式2:
					System.out.print(rs.getString("content"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtils.close(con, pstmt, null);
			}
		}
}
