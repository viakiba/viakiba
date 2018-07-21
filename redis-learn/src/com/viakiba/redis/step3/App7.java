package com.viakiba.redis.step3;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @description: 
 * @author viakiba
 * @date 2017年8月28日
 */
public class App7 {
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
	 * @description: GETSET
	 * 	将给定 key 的值设为 value ，并返回 key 的旧值(old value)。
	 *	当 key 存在但不是字符串类型时，返回一个错误。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		jedis.set("k1", "v1");
		System.out.println(jedis.get("k1"));
		System.out.println(jedis.getSet("k1", "v2"));
		System.out.println(jedis.get("k1"));
		
		jedis.close();
	}
	
	/**
	 * @description: 
	 * 		BITOP
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		//BITOP http://redisdoc.com/string/bitop.html
		
		/*对一个或多个保存二进制位的字符串 key 进行位元操作，并将结果保存到 destkey 上。
		operation 可以是 AND 、 OR 、 NOT 、 XOR 这四种操作中的任意一种：
		BITOP AND destkey key [key ...] ，对一个或多个 key 求逻辑并，并将结果保存到 destkey 。
		BITOP OR destkey key [key ...] ，对一个或多个 key 求逻辑或，并将结果保存到 destkey 。
		BITOP XOR destkey key [key ...] ，对一个或多个 key 求逻辑异或，并将结果保存到 destkey 。
		BITOP NOT destkey key ，对给定 key 求逻辑非，并将结果保存到 destkey 。
		除了 NOT 操作之外，其他操作都可以接受一个或多个 key 作为输入。
		处理不同长度的字符串
		当 BITOP 处理不同长度的字符串时，较短的那个字符串所缺少的部分会被看作 0 。
		空的 key 也被看作是包含 0 的字符串序列。*/
		
		/*jedis.setbit("bits1", 0, true);
		jedis.setbit("bits1", 2, false);
		jedis.setbit("bits1", 3, true);
		System.out.println(jedis.getbit("bits1", 0));
		System.out.println(jedis.getbit("bits1", 1));
		System.out.println(jedis.getbit("bits1", 2));
		System.out.println(jedis.getbit("bits1", 3));
		System.out.println("=====================");
		jedis.setbit("bits2", 0, true);
		jedis.setbit("bits2", 1, true);
		System.out.println(jedis.getbit("bits2", 0));
		System.out.println(jedis.getbit("bits2", 1));
		System.out.println("=====================");
		jedis.bitop(BitOP.OR, "bits3", "bits1", "bits2");
		System.out.println(jedis.getbit("bits3", 0));
		System.out.println(jedis.getbit("bits3", 1));
		System.out.println(jedis.getbit("bits3", 2));
		System.out.println(jedis.getbit("bits3", 3));
		System.out.println("=====================");
		jedis.bitop(BitOP.AND, "bits3", "bits1", "bits2");
		System.out.println(jedis.getbit("bits3", 0));
		System.out.println(jedis.getbit("bits3", 1));
		System.out.println(jedis.getbit("bits3", 2));
		System.out.println(jedis.getbit("bits3", 3));
		System.out.println("=====================");
		jedis.bitop(BitOP.OR, "bits3", "bits1", "bits2");
		System.out.println(jedis.getbit("bits3", 0));
		System.out.println(jedis.getbit("bits3", 1));
		System.out.println(jedis.getbit("bits3", 2));
		System.out.println(jedis.getbit("bits3", 3));
		System.out.println("=====================");
		jedis.bitop(BitOP.XOR, "bits3", "bits1", "bits2");
		System.out.println(jedis.getbit("bits3", 0));
		System.out.println(jedis.getbit("bits3", 1));
		System.out.println(jedis.getbit("bits3", 2));
		System.out.println(jedis.getbit("bits3", 3));*/
		jedis.close();
	}
	
	/**
	 * @description: BITCOUNT
	 * 		http://redisdoc.com/string/bitcount.html
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		jedis.setbit("bits4", 0, true);
		jedis.setbit("bits4", 2, false);
		jedis.setbit("bits4", 3, true);
		Long bitcount = jedis.bitcount("bits4");
		System.out.println(bitcount);
		/*Bitmap 对于一些特定类型的计算非常有效。
		假设现在我们希望记录自己网站上的用户的上线频率，比如说，计算用户 A 上线了多少天，用户 B 上线了多少天，诸如此类，以此作为数据，从而决定让哪些用户参加 beta 测试等活动 —— 这个模式可以使用 SETBIT 和 BITCOUNT 来实现。
		比如说，每当用户在某一天上线的时候，我们就使用 SETBIT ，以用户名作为 key ，将那天所代表的网站的上线日作为 offset 参数，并将这个 offset 上的为设置为 1 。
		举个例子，如果今天是网站上线的第 100 天，而用户 peter 在今天阅览过网站，那么执行命令 SETBIT peter 100 1 ；如果明天 peter 也继续阅览网站，那么执行命令 SETBIT peter 101 1 ，以此类推。
		当要计算 peter 总共以来的上线次数时，就使用 BITCOUNT 命令：执行 BITCOUNT peter ，得出的结果就是 peter 上线的总天数。*/
		jedis.close();
	}
	
	/**
	 * @description: BITFIELD  这个比较复杂
	 * 		http://redisdoc.com/string/bitfield.html
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		/*BITFIELD key [GET type offset] [SET type offset value] [INCRBY type offset increment] [OVERFLOW WRAP|SAT|FAIL]
				BITFIELD 命令可以将一个 Redis 字符串看作是一个由二进制位组成的数组， 并对这个数组中储存的长度不同的整数进行访问 （被储存的整数无需进行对齐）。 换句话说， 通过这个命令， 用户可以执行诸如 “对偏移量 1234 上的 5 位长有符号整数进行设置”、 “获取偏移量 4567 上的 31 位长无符号整数”等操作。 此外， BITFIELD 命令还可以对指定的整数执行加法操作和减法操作， 并且这些操作可以通过设置妥善地处理计算时出现的溢出情况。
				BITFIELD 命令可以在一次调用中同时对多个位范围进行操作： 它接受一系列待执行的操作作为参数， 并返回一个数组作为回复， 数组中的每个元素就是对应操作的执行结果。*/
		System.out.println(jedis.bitfield("mykey", "INCRBY","i8","100","1","get","u4","0"));
		jedis.close();
	}
}
