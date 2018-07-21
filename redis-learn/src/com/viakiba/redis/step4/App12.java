package com.viakiba.redis.step4;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class App12 {
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
//	 * @description: HDEL
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		
		Map<String,String> hash = new HashMap<String,String>();
		hash.put("k3", "v3");
		hash.put("k4", "v4");
		hash.put("k5", "v5");
		jedis.hmset("k2", hash);
		
		System.out.println(jedis.hgetAll("k2"));
//		删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
		System.out.println(jedis.hdel("k2", "k3"));
		System.out.println(jedis.hgetAll("k2"));
		jedis.close();
	}
	
	/**
	 * @description: HINCRBY/HINCRBYFLOAT
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
//		HINCRBY key field increment
		/*为哈希表 key 中的域 field 的值加上增量 increment 。
		增量也可以为负数，相当于对给定域进行减法操作。
		如果 key 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。
		如果域 field 不存在，那么在执行命令前，域的值被初始化为 0 。
		对一个储存字符串值的域 field 执行 HINCRBY 命令将造成一个错误。
		本操作的值被限制在 64 位(bit)有符号数字表示之内。*/
		jedis.hset("in", "cr", "10");
		System.out.println(jedis.hget("in", "cr"));
//		HINCRBYFLOAT key field increment
		jedis.hincrBy("in", "cr", 10);
		System.out.println(jedis.hget("in", "cr"));
		
		jedis.hincrByFloat("in", "cr", 10.52);
		System.out.println(jedis.hget("in", "cr"));
		jedis.close();
	}
}
