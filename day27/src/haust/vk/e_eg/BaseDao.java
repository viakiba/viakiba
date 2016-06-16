package haust.vk.e_eg;

import haust.vk.b_reflect.JdbcUtils;
import haust.vk.utils.Column;
import haust.vk.utils.Id;
import haust.vk.utils.Table;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.ResultSetHandler;


/**
 * @author vk
 *
 * 2016年5月13日
 */

/*
 * 解决优化问题：
 * 	1.当数据库表名与类名不一致
 *  2.字段与属性不一致
 *  3.主键不叫id
 */
public class BaseDao<T> {
	//当前运行类的类型
	private Class<T> clazz;
	//表名
	private String tableName;
	//主键
	private String id_primary;
	
	//拿到当前运行类的参数化类型中 的实际类型（BaseDao<Admin> , Admin.class)
	public BaseDao(){
		Type type=this.getClass().getGenericSuperclass();
		ParameterizedType pt=(ParameterizedType) type;
		Type[] types=pt.getActualTypeArguments();
		clazz=(Class<T>)  types[0];
		
		//已经拿到 ： admin.class
		Table table = clazz.getAnnotation(Table.class);
		tableName=table.tableName();
		
		//获取主键字段
	
		//获取当前运行类的所有字段,遍历.获取每一个字段的id注解
		Field[] fs = clazz.getDeclaredFields();
		
		for(Field f : fs){
			//设置强制访问
			f.setAccessible(true);
			
			//获取每一个字段上的id注解
			Id anno_id = f.getAnnotation(Id.class);
			
			//判断
			if(anno_id != null){
				//如果字段上有id注解，当前字段（field）是主键；再获取字段名称
				Column column=f.getAnnotation(Column.class);
				//主键
				id_primary=column.columnName();
				//跳出循环
				break;
			}
		}
		System.out.println("<====================>");
		System.out.println("表：" +tableName );
		System.out.println("主键：" + id_primary);
		System.out.println("<====================>");
	}
	
	public T findById(int id){
		try {
			String sql="select * from "+ tableName +" where "+id_primary+" =? ";
			/*
			 * DbUtils的已经封装好的工具类：BeanHandler?
			 */
			
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<T>(clazz), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<T> getAll(){
		String sql = "select * from " + tableName;
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<T>(clazz));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}

/**
 * 自定义结果集：封装单个Bean对象
 */
class BeanHandler<T> implements ResultSetHandler<T>{
	// 保存传入的要封装的类的字节码
	private Class<T> clazz;
	
	//
	public BeanHandler(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	//封装结果集的方法
	public T handle(ResultSet rs) throws SQLException {
		
		try {
			//创建要封装的对象
			T 	t = clazz.newInstance();
		//向下读一行
		if(rs.next()){
			
			//1.获取类的所有field字段数组
			Field[] fs = clazz.getDeclaredFields();
			
			//2.遍历，得到每一个字段类型：field
			for(Field f:fs){
				//3.获取属性名称
				String fieldName = f.getName();
				
				//4.获取field字段上的注解   【@Column(columnName = "a_userName")】
				Column column = f.getAnnotation(Column.class);
				
				//5.字段名
				String columnName = column.columnName();
				
				//6.字段值
				Object columnValue = rs.getObject(columnName); //数据库中字段a_userName
				
				//设置（BeanUtils组件）
				BeanUtils.copyProperty(t, fieldName, columnValue);
				
			}
		}
		return t;
	}
		catch (Exception e) {
		throw new RuntimeException(e);
		} 
	}
	}


/*
 * 
*/
class BeanListHandler<T> implements ResultSetHandler<List<T>>{

	//
	private Class<T> clazz;
	
	public  BeanListHandler(Class<T> clazz){
		this.clazz=clazz;
	}
	
	//
	
	public List<T> handle(ResultSet rs) throws SQLException {
		
		List<T> list=new ArrayList<T>();
		
		try {
			while(rs.next()){
				//
				T t=clazz.newInstance();
				
				//
				Field[] fs = clazz.getDeclaredFields();
				for(Field f:fs){
					
					//
					String fieldName = f.getName();
					
					//
					Column column = f.getAnnotation(Column.class);
					
					//
					String columnName = column.columnName();
					//
					Object columnValue = rs.getObject(columnName);
					
					//
					BeanUtils.copyProperty(t, fieldName, columnValue);
					
				}
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}