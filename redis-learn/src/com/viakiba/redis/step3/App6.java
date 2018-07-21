package com.viakiba.redis.step3;

import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @description: redis,String 相关的命令，部分命令在step1中已经演示（set/setnx/setex/get/）
 * @author viakiba
 * @date 2017年8月28日
 */
public class App6 {
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
	 * @description: Append/getrange/SETRANGE/strlen
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
//		jedis.set("demo", "de");//set
//		String string = jedis.get("demo");//get
//		System.out.println(string);
		
//		如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。
//		如果 key 不存在， APPEND 就简单地将给定 key 设为 value ，就像执行 SET key value 一样。
//		jedis.append("demo", "mo");//append
//		http://redisdoc.com/string/append.html
//		扩展 APPEND 可以为一系列定长(fixed-size)数据(sample)提供一种紧凑的表示方式，通常称之为时间序列。
//		每当一个新数据到达的时候，执行以下命令：
//		可以考虑使用 UNIX 时间戳作为时间序列的键名，这样一来，可以避免单个 key 因为保存过大的时间序列而占用大量内存，另一方面，也可以节省下大量命名空间。
		
		jedis.set("ts", "");
		jedis.append("ts", "0043");
		jedis.append("ts", "0056");
		System.out.println(jedis.get("ts"));
		System.out.println(jedis.getrange("ts", 4, 7));
		jedis.setrange("ts", 4, "5600");
		System.out.println(jedis.getrange("ts", 4, 7));
		String str = jedis.get("demo");
		System.out.println(str);
		
//		返回 key 所储存的字符串值的长度。
//		当 key 储存的不是字符串值时，返回一个错误。
		System.out.println(jedis.strlen("ts")+":"+jedis.get("ts"));//strlen 
		jedis.close();
	}
	
	/**
	 * @description: MSET/MGET/MSETNX/PSETEX
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
//		MSET
//		同时设置一个或多个 key-value 对。
//		如果某个给定 key 已经存在，那么 MSET 会用新值覆盖原来的旧值，如果这不是你所希望的效果，请考虑使用 MSETNX 命令：它只会在所有给定 key 都不存在的情况下进行设置操作。
//		MSET 是一个原子性(atomic)操作，所有给定 key 都会在同一时间内被设置，某些给定 key 被更新而另一些给定 key 没有改变的情况，不可能发生。
		jedis.mset("1","2","3","4","5","6","7","8");
		
//		MGET
//		返回所有(一个或多个)给定 key 的值。
//		如果给定的 key 里面，有某个 key 不存在，那么这个 key 返回特殊值 nil 。因此，该命令永不失败。
		List<String> mget = jedis.mget("1","3","5","7","9");
		System.out.println(mget);
		
		jedis.close();
	}
	
	/**
	 * @description: SETBIT
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		/*对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)。
		位的设置或清除取决于 value 参数，可以是 0 也可以是 1 。
		当 key 不存在时，自动生成一个新的字符串值。
		字符串会进行伸展(grown)以确保它可以将 value 保存在指定的偏移量上。当字符串值进行伸展时，空白位置以 0 填充。
		offset 参数必须大于或等于 0 ，小于 2^32 (bit 映射被限制在 512 MB 之内)。*/
		jedis.setbit("bit", 100, false);
		System.out.println(jedis.getbit("bit", 99));
		System.out.println(jedis.getbit("bit", 100));
		jedis.setbit("bit", 102, true);
		System.out.println(jedis.getbit("bit",100));
		System.out.println(jedis.getbit("bit",101));
		System.out.println(jedis.getbit("bit",102));
		jedis.close();
	}
	
	
}
