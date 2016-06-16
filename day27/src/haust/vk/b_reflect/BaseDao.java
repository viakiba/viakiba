package haust.vk.b_reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * @author vk
 *
 * 2016年5月11日
 */
public class BaseDao<T> {
	//保存当前运行类的参数化类型中的实际类型
	private Class clazz;
	//表名
	private String tableName;
	
	//构造函数：
	public BaseDao(){
		//this 表示当前运行类（Account/AdminDao)
		//this.getClass() 当前运行类的字节码（即 AccountDao.class / AdminDao,class ）
		//this.getClass().getGenericSuperClass() 
		//表示当前的运行类的父类 即为：BaseDao<Account>  
		//  "参数化类型" parameterizedType
		
		Type type=this.getClass().getGenericSuperclass();
		
		//强制转化为  参数化类型 【BaseDao<Account>】
		ParameterizedType pt=(ParameterizedType) type;
		//获取参数化类型 ， 实际类型的定义 【new Type[]{Account.class}】
		Type types[]=pt.getActualTypeArguments();
		//获取数据的第一个元素 ： Account.class
		clazz=(Class) types[0];
		//表明（与类名一样，只要获取类名就行）
		tableName=clazz.getSimpleName();
	}
	
	/*
	 * 主键查询
	 * id 主键
	 * return 返回封装后的对象
	 */
	public T findById(int id){
		/*
		 * 1.知道封装的对象的类型
		 * 2.表名 表名与对象名一样 且主键都为 id
		 * 
		 * 即
		 * ---》得到当前运行类继承的父类 basedao<Account>
		 * --->得到Account.class
		 */
		String sql="select * from "+ tableName +" where id=?";
		
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<T>(clazz),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		
	}
	
	public List<T> getAll(){
		String sql=" select * from "+tableName;
		
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<T>(clazz));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
