package com.viakiba.redis.step5;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class App16 {
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
	 * @description: BRPOPLPUSH/LRANGE/LREM
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		//连接测试是否通过
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		jedis.flushAll();
		jedis.lpush("listdemo2", "g");
		jedis.lpush("listdemo1", "a","b","c","d","e","f");
		
		/*返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定。
		下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。
		你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。*/
		System.out.println(jedis.lrange("listdemo1", 2, 4));
		
		String brpoplpush = jedis.brpoplpush("listdemo1", "listdemo2", 10000);
		
		jedis.lpush("temp", brpoplpush);
		/*根据参数 count 的值，移除列表中与参数 value 相等的元素。
		count 的值可以是以下几种：
			count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。
			count < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。
			count = 0 : 移除表中所有与 value 相等的值。*/
		System.out.println(jedis.llen("temp"));
		Long lrem = jedis.lrem("temp", 0, brpoplpush);
		System.out.println(lrem);
		System.out.println(jedis.llen("temp"));
		jedis.close();
	}
}
