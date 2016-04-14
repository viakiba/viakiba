package haust.vk.b_pool;

import haust.vk.utils.JdbcUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;


/**
 * 自定义连接池, 管理连接
 * 代码实现：
	1.  MyPool.java  连接池类，   
	2.  指定全局参数：  初始化数目、最大连接数、当前连接、   连接池集合
	3.  构造函数：循环创建3个连接
	4.  写一个创建连接的方法
	5.  获取连接
	------>  判断： 池中有连接， 直接拿
	 ------>                池中没有连接，
	------>                 判断，是否达到最大连接数； 达到，抛出异常；没有达到最大连接数，
			创建新的连接
	6. 释放连接
	 ------->  连接放回集合中(..)
 *
 */


public class MyPool {
	private int init_count=3;//初始化连接数目
	private int max_count=6;//最大连接数
	private int current_count=0;//当前连接数
	//连接池集合
	private LinkedList<Connection> pool=new LinkedList<Connection>();
	
	//构造函数，初始化连接放入连接池
	public MyPool(){
		for(int i=0;i<current_count;i++){
			Connection con=JdbcUtil.getConnection();
			pool.addLast(con);
			current_count++;
		}
	}
	
	//创建一个新的连接方法
	private Connection createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			final Connection con=DriverManager.getConnection("jdbc:mysql:///jdbc_demo", "root", "root");
			
			//对con的对象的代理
			Connection proxy=(Connection) Proxy.newProxyInstance(
					con.getClass().getClassLoader(),//类加载器
					new Class[]{Connection.class}, //目标对象实现的接口类型
					new InvocationHandler() {
						//事件监听处理器
						@Override
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							//方法返回值
							Object result=null;
							//获取监听方法
							String methodName = method.getName();
							
							//假如匹配，则执行
							if("close".equals(methodName)){
								System.out.println("begin:执行close");
								pool.addLast(con);
								current_count--;
								System.out.println("end:回收完成");
							}else{//不匹配，执行默认的方法
								result=method.invoke(con, args);
							}
							//返回方法返回值
							return result;
						}
					}
				);
			//不进行事件监听的话，则返回默认的
		return proxy;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//获取连接
	public Connection getConnection(){
		
		if(pool.size()>0){
			//连接池还有剩余连接，取出返回Connection对象
			return pool.removeFirst();
		}
		//连接池中连接用尽：如果没有达到最大连接数，则创建连接
		if(current_count<max_count){
			
			current_count++;
			
			return createConnection();
		}
		// 如果当前已经达到最大连接数，抛出异常
		throw new RuntimeException("当前连接数达到最大");
	}
	
	//释放连接
	public void realeaseConnection(Connection con){
		//如果池的数目如果小于初始化连接，就放入池中
		if(pool.size()<init_count){
			pool.addLast(con);
		}else{
			//关闭
			try {
				current_count--;
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		MyPool pool=new MyPool();
		System.out.println("当前连接数："+pool.current_count);
		
		//使用连接
		//pool.getConnection();
		pool.getConnection();
		Connection con5=pool.getConnection();
		Connection con4=pool.getConnection();
		Connection con3=pool.getConnection();
		Connection con2=pool.getConnection();
		Connection con1=pool.getConnection();
		// 释放连接, 连接放回连接池
		//pool.realeaseConnection(con1);
		/*
		 * 希望：当关闭连接的时候，要把连接放入连接池！【当调用Connection接口的close方法时候，希望触发pool.addLast(con);操作】
		 * 																			把连接放入连接池
		 * 解决1：实现Connection接口，重写close方法
		 * 解决2：动态代理
		 */
		con5.close();
		//con4.close();
		System.out.println("连接池"+pool.pool.size());
		System.out.println("当前连接"+pool.current_count);
	}
}
