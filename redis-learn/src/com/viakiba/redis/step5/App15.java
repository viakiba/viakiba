package com.viakiba.redis.step5;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class App15 {
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
	 * 		RPOP/RPOPLPUSH
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		//连接测试是否通过
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		jedis.lpush("listdemo1", "a","b","c","d","e","f");
		System.out.println(jedis.llen("listdemo1"));
//		移除并返回列表 key 的尾元素。
		System.out.println(jedis.rpop("listdemo1"));
		System.out.println(jedis.llen("listdemo1"));
		
		
		jedis.close();
	}
	
	/**
	 * @description: 
	 * 		BLPOP/BRPOP
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		//连接测试是否通过
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		/*BRPOP 是列表的阻塞式(blocking)弹出原语。  http://redisdoc.com/list/brpop.html
		它是 RPOP 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 BRPOP 命令阻塞，直到等待超时或发现可弹出元素为止。
		当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的尾部元素。
		关于阻塞操作的更多信息，请查看 BLPOP 命令， BRPOP 除了弹出元素的位置和 BLPOP 不同之外，其他表现一致。*/
		
		/*BLPOP 是列表的阻塞式(blocking)弹出原语。  http://redisdoc.com/list/blpop.html
		它是 LPOP 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 BLPOP 命令阻塞，直到等待超时或发现可弹出元素为止。
		当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的头元素。*/
		
		jedis.close();
	}
	
	
}
