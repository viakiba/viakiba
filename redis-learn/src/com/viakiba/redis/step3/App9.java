package com.viakiba.redis.step3;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class App9 {
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
	 * @description: INCR/INCRBY/INCRBYFLOAT
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		jedis.flushAll();
		jedis.set("k", "10");
		
		System.out.println(jedis.get("k"));
		jedis.incr("k");
		System.out.println(jedis.get("k"));
		jedis.incrBy("k", 5);
		System.out.println(jedis.get("k"));
		jedis.incrByFloat("k", 10.52);
		System.out.println(jedis.get("k"));
		jedis.close();
	}
}
