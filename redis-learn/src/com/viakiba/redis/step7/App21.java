package com.viakiba.redis.step7;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class App21 {
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
	 * 		ZREM:
	 * 			移除有序集 key 中的一个或多个成员，不存在的成员将被忽略。
	 * 			当 key 存在但不是有序集类型时，返回一个错误。
	 * 		ZREMRANGEBYRANK:
	 * 			移除有序集 key 中，指定排名(rank)区间内的所有成员。
	 * 			区间分别以下标参数 start 和 stop 指出，包含 start 和 stop 在内。
	 * 			下标参数 start 和 stop 都以 0 为底，也就是说，以 0 表示有序集第一个成员，以 1 表示有序集第二个成员，以此类推。
	 * 			你也可以使用负数下标，以 -1 表示最后一个成员， -2 表示倒数第二个成员，以此类推。
	 * 		ZREMRANGEBYSCORE:
	 * 			移除有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。
	 * 		ZREMRANGEBYLEX:
	 * 			对于一个所有成员的分值都相同的有序集合键 key 来说， 这个命令会移除该集合中， 成员介于 min 和 max 范围内的所有元素。
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
		
		System.out.println(jedis.zrange("k1", 0, 10));
		Long zrem = jedis.zrem("k1", "mem1");
		System.out.println(zrem);
		System.out.println(jedis.zrange("k1", 0, 10));
		
		Long zremrangeByRank = jedis.zremrangeByRank("k1", 0, 1);
		System.out.println(zremrangeByRank);
		System.out.println(jedis.zrange("k1", 0, 10));
		
		Long zremrangeByScore = jedis.zremrangeByScore("k1", "2", "5");
		System.out.println(zremrangeByScore);
		System.out.println(jedis.zrange("k1", 0, 10));
		
		Long zremrangeByLex = jedis.zremrangeByLex("k1", "[mem4", "[mem6");
		System.out.println(zremrangeByLex);
		System.out.println(jedis.zrange("k1", 0, 10));
		
		jedis.close();
	}
	
}
