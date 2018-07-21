package com.viakiba.redis.step3;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class App8 {
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
	 * 		DECR
	 * 			http://redisdoc.com/string/decr.html
	 * 		将 key 中储存的数字值减一。
	 * 		如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECR 操作。
	 * 		如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
	 * 		本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * 		关于递增(increment) / 递减(decrement)操作的更多信息，请参见 INCR 命令。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		jedis.set("k", "10");
		System.out.println(jedis.get("k"));
		jedis.decr("k");
		System.out.println(jedis.get("k"));
		jedis.close();
	}
	
	/**
	 * @description: DECRBY
	 * 		http://redisdoc.com/string/decrby.html将 key 所储存的值减去减量 decrement 。
	 * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECRBY 操作。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
	 * 本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		jedis.set("k", "10");
		System.out.println(jedis.get("k"));
		jedis.decrBy("k",5);
		System.out.println(jedis.get("k"));
		jedis.close();
	}
	
}
