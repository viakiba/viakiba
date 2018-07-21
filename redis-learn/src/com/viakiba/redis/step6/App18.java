package com.viakiba.redis.step6;

import java.util.Set;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;

public class App18 {
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
	 * 		SREM/SSCAN
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		//连接测试是否通过
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		jedis.flushAll();
		System.out.println("=========================");
		jedis.sadd("bbs", "baidu");
		jedis.sadd("bbs", "baidu.com");
		
		System.out.println(jedis.smembers("bbs"));
//		移除集合 key 中的一个或多个 member 元素，不存在的 member 元素会被忽略。
//		当 key 不是集合类型，返回一个错误。
		System.out.println(jedis.srem("bbs", "bai","baidu"));
		
		System.out.println(jedis.smembers("bbs"));
		System.out.println("=========================");
		
		
//		SSCAN:命令用于迭代集合键中的元素。  sscan 将被移除  http://redisdoc.com/key/scan.html#scan
		@SuppressWarnings("deprecation")
		ScanResult<String> sscan = jedis.sscan("bbs", 1);
		@SuppressWarnings("deprecation")
		int cursor = sscan.getCursor();
		String stringCursor = sscan.getStringCursor();
		System.out.println(cursor);
		System.out.println(stringCursor);
		
		jedis.close();
	}
	
	/**
	 * @description: 
	 * 		SUNION/SUNIONSTORE
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		jedis.flushAll();
		System.out.println("=========================");
		jedis.sadd("bb", "baidus");
		jedis.sadd("bbs", "baiduss");
		jedis.sadd("bbs", "baidu.com");
		System.out.println(jedis.smembers("bb"));
		System.out.println(jedis.smembers("bbs"));
		System.out.println("=========================");
//		返回一个集合的全部成员，该集合是所有给定集合的并集。
		Set<String> sunion = jedis.sunion("bb","bbs");
		System.out.println(sunion);
		System.out.println("=========================");
		
		/*这个命令类似于 SUNION 命令，但它将结果保存到 destination 集合，而不是简单地返回结果集。
		如果 destination 已经存在，则将其覆盖。
		destination 可以是 key 本身。*/
		Long sunionstore = jedis.sunionstore("b", "bb","bbs");
		System.out.println(sunionstore);
		System.out.println(jedis.smembers("b"));
		
		jedis.close();
	}
}
