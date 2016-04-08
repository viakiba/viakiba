package haust.vk.c_jdbc;

import haust.vk.JdbcUtil.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
	//通用的dao，自己写的所有的dao都集成此类
	/*
	 * 此类定义了两个方法
	 * 1.更新
	 * 2.查询
	 */
public class BaseDao {
	
	// 初始化参数
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	/**
	 * 更新的通用方法
	 * @param sql   更新的sql语句(update/insert/delete)
	 * @param paramsValue  sql语句中占位符对应的值(如果没有占位符，传入null)
	 */
	
	public void update(String sql,Object[] paramsValue){
		try {
			// 获取连接
			con=JdbcUtil.getConnection();
			// 创建执行命令的stmt对象
			pstmt=con.prepareStatement(sql);
			// 参数元数据： 得到占位符参数的个数
			int count=pstmt.getParameterMetaData().getParameterCount();
			
			if(paramsValue!=null && paramsValue.length>0){
				for(int i=0;i<count;i++){
				pstmt.setObject(i+1, paramsValue[i]);
				}
			}
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.closeAll(pstmt, con, rs);
		}
	}
		/**
		 * 查询的通用方法
		 * @param sql
		 * @param paramsValue
		 */
		
		public <T> List<T> query(String sql,Object[] paramsValue,Class<T> calzz){
			List<T> list;
			try {
				list = new ArrayList<T>();
				//对象
				T t=null;
				
				//获取连接
				con=JdbcUtil.getConnection();
				//创建stmt对象
				pstmt=con.prepareStatement(sql);
				
				int count=pstmt.getParameterMetaData().getParameterCount();
				
				if(paramsValue!=null && paramsValue.length>0){
					for(int i=0;i<count;i++){
						pstmt.setObject(i+1, paramsValue[i]);
					}
				}
				//执行查询
				rs=pstmt.executeQuery();
				//获取结果集元数据
				ResultSetMetaData rsmd = rs.getMetaData();
				//---->获取列的个数
				int columnCount=rsmd.getColumnCount();
				//遍历rs
				while(rs.next()){
					//要封装的对象
					t=calzz.newInstance();
					//遍历每一行的每一列拿到数据
					for(int i=0;i<columnCount;i++){
						String columnName=rsmd.getColumnName(i+1);
						Object value=rs.getObject(columnName);
						
						BeanUtils.copyProperty(t, columnName, value);
					}
					list.add(t);	
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				JdbcUtil.closeAll(pstmt, con, rs);
			}
	}
	
}
