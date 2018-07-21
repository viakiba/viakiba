package com.viakiba.redis.step6;

import java.util.Set;

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
	 * @description: 测试连接是否通过
	 * 		SADD/SMEMBERS/SISMEMBER/SPOP/SRANDMEMBER
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		//连接测试是否通过
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		System.out.println("=========================");
		/*将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略。
		假如 key 不存在，则创建一个只包含 member 元素作成员的集合。*/
		jedis.sadd("bbs", "baidu");
		jedis.sadd("bbs", "baidu.com");
		jedis.sadd("bbs", "bai","baidu");
		/*返回集合 key 中的所有成员。
		不存在的 key 被视为空集合。*/
		Set<String> smembers = jedis.smembers("bbs");
		System.out.println(smembers);
		
		System.out.println("=========================");
//		判断 member 元素是否集合 key 的成员。
		System.out.println(jedis.sismember("bbs", "baidu"));
		System.out.println(jedis.sismember("bbs", "baidus"));
		
		System.out.println("=========================");
		System.out.println(jedis.smembers("bbs"));
//		移除并返回集合中的一个随机元素。
		System.out.println(jedis.spop("bbs"));
		System.out.println(jedis.smembers("bbs"));
		System.out.println("=========================");
		
//		如果命令执行时，只提供了 key 参数，那么返回集合中的一个随机元素。
		System.out.println(jedis.srandmember("bbs"));
		/*如果 count 为正数，且小于集合基数，那么命令返回一个包含 count 个元素的数组，数组中的元素各不相同。如果 count 大于等于集合基数，那么返回整个集合。
		如果 count 为负数，那么命令返回一个数组，数组中的元素可能会重复出现多次，而数组的长度为 count 的绝对值。*/
		System.out.println(jedis.srandmember("bbs",2));
		System.out.println(jedis.srandmember("bbs",-2));
		jedis.close();
	}
	
	/**
	 * @description: 
	 * 		SMOVE
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		System.out.println("=========================");
		/*SMOVE:
		将 member 元素从 source 集合移动到 destination 集合。
		SMOVE 是原子性操作。
		如果 source 集合不存在或不包含指定的 member 元素，则 SMOVE 命令不执行任何操作，仅返回 0 。
		否则， member 元素从 source 集合中被移除，并添加到 destination 集合中去。
		当 destination 集合已经包含 member 元素时， SMOVE 命令只是简单地将 source 集合中的 member 元素删除。
		当 source 或 destination 不是集合类型时，返回一个错误。*/
		jedis.sadd("bbs", "baidu");
		jedis.sadd("bbs", "baidu.com");
		jedis.sadd("bbss", "baidu.coms");
		System.out.println(jedis.smembers("bbs"));
		jedis.smove("bbs", "bbss","baidu");
		System.out.println(jedis.smembers("bbs"));
		System.out.println(jedis.smembers("bbss"));
		System.out.println("=========================");
		jedis.close();
	}
	
}
