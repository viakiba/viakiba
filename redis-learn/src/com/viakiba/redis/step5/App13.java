package com.viakiba.redis.step5;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @description: 
 * @author viakiba
 * @date 2017年8月30日
 */
public class App13 {
	static interface RedisConfig {
		public final static String HOST = "viakiba.cn";
		public final static int PORT = 6379;
	}
	
	/**
	 * @description: 测试连接是否通过
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		//连接测试是否通过
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		System.out.println(jedis.ping());//pong则通过
		jedis.close();
	}
	
	/**
	 * @description: 
	 * 		lpush/lpushx/lpop
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		/*将一个或多个值 value 插入到列表 key 的表头
		如果有多个 value 值，那么各个 value 值按从左到右的顺序依次插入到表头： 比如说，对空列表 mylist 
		执行命令 LPUSH mylist a b c ，列表的值将是 c b a ，这等同于原子性地执行 LPUSH mylist a 、 LPUSH mylist b 和 LPUSH mylist c 三个命令。
		如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作。
		当 key 存在但不是列表类型时，返回一个错误。*/
		System.out.println(jedis.lpush("listdemo1", "a","b"));
		/*将值 value 插入到列表 key 的表头，当且仅当 key 存在并且是一个列表。
		和 LPUSH 命令相反，当 key 不存在时， LPUSHX 命令什么也不做。*/
		System.out.println(jedis.lpushx("listdemo1", "c"));//lpushx 只能是单个参数
		
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		
		System.out.println(jedis.lpop("listdemo1"));
		
		jedis.close();
	}
	
	/**
	 * @description: lset
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		System.out.println(jedis.lpush("listdemo1", "a","b","c"));
		/*将列表 key 下标为 index 的元素的值设置为 value 。
		当 index 参数超出范围，或对一个空列表( key 不存在)进行 LSET 时，返回一个错误。
		关于列表下标的更多信息，请参考 LINDEX 命令。*/
		System.out.println(jedis.lset("listdemo1", 1, "d"));
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		
		jedis.close();
	}
	
	/**
	 * @description: rpush
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		System.out.println(jedis.lpush("listdemo1", "a","b","c"));
		/*将一个或多个值 value 插入到列表 key 的表尾(最右边)。
		如果有多个 value 值，那么各个 value 值按从左到右的顺序依次插入到表尾：比如对一个空列表 
		mylist 执行 RPUSH mylist a b c ，得出的结果列表为 a b c ，等同于执行命令 RPUSH mylist a 、 RPUSH mylist b 、 RPUSH mylist c 。
		如果 key 不存在，一个空列表会被创建并执行 RPUSH 操作。
		当 key 存在但不是列表类型时，返回一个错误。*/
		jedis.rpush("listdemo1", "d");
		
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		
		jedis.close();
	}
	
	/**
	 * @description: rpushx
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		System.out.println(jedis.lpush("listdemo1", "a","b","c"));
		/*将值 value 插入到列表 key 的表尾，当且仅当 key 存在并且是一个列表。
			和 RPUSH 命令相反，当 key 不存在时， RPUSHX 命令什么也不做。*/
		jedis.rpushx("listdemo1", "d");
		
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		
		jedis.close();
	}
}
