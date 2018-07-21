package com.viakiba.redis.step7;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class App19 {
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
	 * 				zadd:
	 * 					将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
	 * 					如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该 member 在正确的位置上。
	 * 					score 值可以是整数值或双精度浮点数。如果 key 不存在，则创建一个空的有序集并执行 ZADD 操作。
	 * 					当 key 存在但不是有序集类型时，返回一个错误。对有序集的更多介绍请参见 sorted set 。
	 * 				zcard:
	 * 					返回有序集 key 的基数。
	 * 				ZCOUNT
	 * 					返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max )的成员的数量。
	 * 				ZSCORE
	 * 					返回有序集 key 中，成员 member 的 score 值。如果 member 元素不是有序集 key 的成员，或 key 不存在，返回 nil 。
	 * 				ZRANK
	 * 					返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递增(从小到大)顺序排列。
	 * 					排名以 0 为底，也就是说， score 值最小的成员排名为 0 。
	 * 					使用 ZREVRANK 命令可以获得成员按 score 值递减(从大到小)排列的排名。
	 * 				ZREVRANK:
	 * 					返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递减(从大到小)排序。
	 * 					排名以 0 为底，也就是说， score 值最大的成员排名为 0 。
	 * 					使用 ZRANK 命令可以获得成员按 score 值递增(从小到大)排列的排名。
	 * 				ZINCRBY:
	 * 					为有序集 key 的成员 member 的 score 值加上增量 increment 。
	 * 					可以通过传递一个负数值 increment ，让 score 减去相应的值，比如 ZINCRBY key -5 member ，就是让 member 的 score 值减去 5 。
	 * 					当 key 不存在，或 member 不是 key 的成员时， ZINCRBY key increment member 等同于 ZADD key increment member 。
	 * 					当 key 不是有序集类型时，返回一个错误。score 值可以是整数值或双精度浮点数。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		Map<String,Double> scoreMembers = new HashMap<>();
		scoreMembers.put("mem1", 1.0);
		scoreMembers.put("mem2", 2.0);
		jedis.zadd("k1", scoreMembers);
		System.out.println(jedis.zcard("k1"));
		Long zcount = jedis.zcount("k1", 0, 2);
		System.out.println(zcount);
		Double zscore = jedis.zscore("k1", "mem1");
		System.out.println(zscore);
		jedis.zincrby("k1", 3, "mem1");
		zscore = jedis.zincrby("k1",10 ,"mem1");
		System.out.println(zscore);
		
		Long zrank = jedis.zrank("k1", "mem1");
		System.out.println(zrank);
		zrank = jedis.zrank("k1", "mem2");
		System.out.println(zrank);
		
		Long zrevrank = jedis.zrevrank("k1", "mem2");
		System.out.println(zrevrank);
		
		jedis.close();
	}
	
}
