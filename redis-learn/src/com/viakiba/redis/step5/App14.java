package com.viakiba.redis.step5;

import org.junit.Test;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;

/**
 * @description: 
 * @author viakiba
 * @date 2017年8月30日
 */
public class App14 {
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
	 * @description: LTRIM
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		System.out.println(jedis.lpush("listdemo1", "a","b","c","d","e","f"));
//		对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
//		你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
		System.out.println(jedis.ltrim("listdemo1", 3, 5));
		
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		System.out.println(jedis.lpop("listdemo1"));
		
		System.out.println(jedis.lpop("listdemo1"));
		jedis.close();
	}
	
	/**
	 * @description: LLEN/LINDEX
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		System.out.println(jedis.lpush("listdemo1", "a","b","c","d","e"));
		/*返回列表 key 的长度。
		如果 key 不存在，则 key 被解释为一个空列表，返回 0 .
		如果 key 不是列表类型，返回一个错误。*/
		System.out.println(jedis.llen("listdemo1"));
		
		System.out.println(jedis.lindex("listdemo1", 1));
		System.out.println(jedis.lindex("listdemo1", 2));
		jedis.close();
	}
	
	/**
	 * @description: LINSERT
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		System.out.println(jedis.lpush("listdemo1", "a","b","c","d","e","f"));
		
		/*将值 value 插入到列表 key 当中，位于值 pivot 之前或之后。
		当 pivot 不存在于列表 key 时，不执行任何操作。
		当 key 不存在时， key 被视为空列表，不执行任何操作。
		如果 key 不是列表类型，返回一个错误。*/
		Long linsert = jedis.linsert("listdemo1", LIST_POSITION.AFTER, "e", "g");
		/*
		返回值：
			如果命令执行成功，返回插入操作完成之后，列表的长度。
			如果没有找到 pivot ，返回 -1 。
			如果 key 不存在或为空列表，返回 0 。
		*/
		System.out.println(linsert);
		jedis.close();
	}
}
