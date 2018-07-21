package com.viakiba.redis.step7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class App20 {
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
	 * 			ZRANGE:
	 * 				返回有序集 key 中，指定区间内的成员。  索引
	 * 				其中成员的位置按 score 值递增(从小到大)来排序。
	 * 				具有相同 score 值的成员按字典序(lexicographical order )来排列。
	 * 				如果你需要成员按 score 值递减(从大到小)来排列，请使用 ZREVRANGE 命令。
	 * 				下标参数 start 和 stop 都以 0 为底，也就是说，以 0 表示有序集第一个成员，以 1 表示有序集第二个成员，以此类推。
	 * 				你也可以使用负数下标，以 -1 表示最后一个成员， -2 表示倒数第二个成员，以此类推。
	 * 				超出范围的下标并不会引起错误。
	 * 				比如说，当 start 的值比有序集的最大下标还要大，或是 start > stop 时， ZRANGE 命令只是简单地返回一个空列表。
	 * 				另一方面，假如 stop 参数的值比有序集的最大下标还要大，那么 Redis 将 stop 当作最大下标来处理。
	 * 				可以通过使用 WITHSCORES 选项，来让成员和它的 score 值一并返回，返回列表以 value1,score1, ..., valueN,scoreN 的格式表示。
	 * 				客户端库可能会返回一些更复杂的数据类型，比如数组、元组等。
	 * 			ZREVRANGE
	 * 				返回有序集 key 中，指定区间内的成员。
	 * 				其中成员的位置按 score 值递减(从大到小)来排列。
	 * 				具有相同 score 值的成员按字典序的逆序(reverse lexicographical order)排列。
	 * 				除了成员按 score 值递减的次序排列这一点外， ZREVRANGE 命令的其他方面和 ZRANGE 命令一样。
	 * 			ZRANGEBYSCORE:  分数
	 * 				返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
	 * 				具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
	 * 				可选的 LIMIT 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
	 * 				可选的 WITHSCORES 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
	 * 				该选项自 Redis 2.0 版本起可用。
	 * 				区间及无限
	 * 				min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 ZRANGEBYSCORE 这类命令。
	 * 				默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
	 * 			ZREVRANGEBYSCORE：
	 * 				返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
	 * 				具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
	 * 				除了成员按 score 值递减的次序排列这一点外， ZREVRANGEBYSCORE 命令的其他方面和 ZRANGEBYSCORE 命令一样。
	 * 			ZRANGEBYLEX:
	 * 				当有序集合的所有成员都具有相同的分值时， 有序集合的元素会根据成员的字典序（lexicographical ordering）来进行排序， 而这个命令则可以返回给定的有序集合键 key 中， 值介于 min 和 max 之间的成员。
	 * 				如果有序集合里面的成员带有不同的分值， 那么命令返回的结果是未指定的（unspecified）。
	 * 				命令会使用 C 语言的 memcmp() 函数， 对集合中的每个成员进行逐个字节的对比（byte-by-byte compare）， 并按照从低到高的顺序， 返回排序后的集合成员。 如果两个字符串有一部分内容是相同的话， 那么命令会认为较长的字符串比较短的字符串要大。
	 * 				可选的 LIMIT offset count 参数用于获取指定范围内的匹配元素 （就像 SQL 中的 SELECT LIMIT offset count 语句）。 需要注意的一点是， 如果 offset 参数的值非常大的话， 那么命令在返回结果之前， 需要先遍历至 offset 所指定的位置， 这个操作会为命令加上最多 O(N) 复杂度。
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
		
		Set<String> zrange = jedis.zrange("k1", 0, 3);
		System.out.println(zrange);
		Set<String> zrevrange = jedis.zrevrange("k1", 0, 3);
		System.out.println(zrevrange);
		
		Set<String> zrangeByScore = jedis.zrangeByScore("k1", 3, 4);
		System.out.println(zrangeByScore);
		
		Set<String> zrevrangeByScore = jedis.zrevrangeByScore("k1", 3, 4);
		System.out.println(zrevrangeByScore);
		
		System.out.println(jedis.zrangeByLex("k1", "-", "+",1,2));
		System.out.println(jedis.zrangeByLex("k1", "(mem2", "+"));
		System.out.println(jedis.zrangeByLex("k1", "-", "[mem5"));
		System.out.println(jedis.zrangeByLex("k1", "[mem2", "[mem5"));
		System.out.println(jedis.zrangeByLex("k1", "(mem2", "(mem5"));
		jedis.close();
	}
}
