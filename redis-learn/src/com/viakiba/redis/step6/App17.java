package com.viakiba.redis.step6;

import java.util.Set;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class App17 {
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
	 * 		SCARD
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		//连接测试是否通过
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		System.out.println("====================");
		jedis.sadd("bbs", "bai","baidu");
//		返回集合 key 的基数(集合中元素的数量)。
		Long scard = jedis.scard("bbs");
		System.out.println(scard);
		System.out.println("====================");
		jedis.close();
	}
	
	/**
	 * @description: 
	 * 		SINTER/SINTERSTORE
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		System.out.println("====================");
		jedis.sadd("bb", "bai","baidu","bu");
		jedis.sadd("bbs", "bai.com","baidu");

//		返回一个集合的全部成员，该集合是所有给定集合的交集。
//		不存在的 key 被视为空集。
//		当给定集合当中有一个空集时，结果也为空集(根据集合运算定律)。
		Set<String> sinter = jedis.sinter("bbs","bb");
		System.out.println(sinter);
		
		System.out.println("====================");
		Long sinterstore = jedis.sinterstore("b", "bb","bbs");
		System.out.println(sinterstore);
		System.out.println(jedis.smembers("b"));
		
		System.out.println("====================");
		
		jedis.close();
	}
	
	/**
	 * @description: 
	 * 		SDIFF/SDIFFSTORE
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		
		jedis.sadd("bb", "bai","baidu","bu");
		jedis.sadd("bbs", "bai.com","baidu");
		System.out.println(jedis.smembers("bbs"));
		System.out.println(jedis.smembers("bb"));
//		返回一个集合的全部成员，该集合是所有给定集合之间的差集。
		Set<String> sdiff = jedis.sdiff("bb","bbs");
		System.out.println(sdiff);
		
		Long b = jedis.sdiffstore("b", "bb","bbs");
		System.out.println(b);
		System.out.println(jedis.smembers("b"));
		
		jedis.close();
	}
}
