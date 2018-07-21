package com.viakiba.redis.step7;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;

public class App22 {
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
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		System.out.println(jedis.ping());//pong则通过
		jedis.close();
	}
	
	/**
	 * @description: 
	 * 			ZUNIONSTORE：http://redisdoc.com/sorted_set/zunionstore.html
	 * 				计算给定的一个或多个有序集的并集，其中给定 key 的数量必须以 numkeys 参数指定，并将该并集(结果集)储存到 destination 。
	 * 				默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之 和 。
	 * 			ZINTERSTORE：http://redisdoc.com/sorted_set/zinterstore.html
	 * 				计算给定的一个或多个有序集的交集，其中给定 key 的数量必须以 numkeys 参数指定，并将该交集(结果集)储存到 destination 。
	 * 				默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之和.
	 * 			ZSCAN：
	 * 				用于迭代有序集合中的元素（包括元素成员和元素分值）。  http://redisdoc.com/key/scan.html#scan
	 * 			ZLEXCOUNT：
	 * 				对于一个所有成员的分值都相同的有序集合键 key 来说， 这个命令会返回该集合中， 成员介于 min 和 max 范围内的元素数量。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		
		Map<String,Double> scoreMembers = new HashMap<>();
		scoreMembers.put("mem1", 1.0);
		scoreMembers.put("mem2", 2.0);
		scoreMembers.put("mem3", 2.1);
		scoreMembers.put("mem4", 3.5);
		scoreMembers.put("mem5", 5.0);
		scoreMembers.put("mem31", 3.1);
		scoreMembers.put("mem5", 6.0);
		scoreMembers.put("mem7", 7.0);
		jedis.zadd("k1", scoreMembers);
		
		scoreMembers.clear();
		scoreMembers.put("mem4", 3.5);
		scoreMembers.put("mem5", 5.0);
		scoreMembers.put("mem32", 3.1);
		jedis.zadd("k2", scoreMembers);
		
		System.out.println(jedis.zrange("k1", 0, 10));
		
		ZParams zParams = new ZParams();
        zParams.aggregate(ZParams.Aggregate.MAX);
		jedis.zunionstore("des", zParams , "k1","k2");
		
		System.out.println(jedis.zrange("des", 0, 10));
		jedis.zinterstore("dest", zParams,"k1","k2");
		System.out.println(jedis.zrange("dest", 0, 10));
		System.out.println(jedis.zlexcount("k1", "[mem2", "[mem5"));
		
		jedis.close();
	}
	
	@Test
	public void test3() throws Exception {
		int count = 0;
		int i =1;
		while(i<30){
			count = count + i*(i+1)*(i+2);
			System.out.println(">>>>>>"+i+"<<<<<<<");
			i=i+3;
		}
		System.out.println(count);
	}
}
