package com.viakiba.redis.step4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class App10 {
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
	 * 		HGET/HGETALL/HMGET/HMSET/HSET/HSETNX
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		/*将哈希表 key 中的域 field 的值设为 value 。
		如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作。
		如果域 field 已经存在于哈希表中，旧值将被覆盖。*/
		jedis.hset("k1", "website", "baidu.com");
//		返回哈希表 key 中给定域 field 的值。
		System.out.println(jedis.hget("k1", "website"));
		/*将哈希表 key 中的域 field 的值设置为 value ，当且仅当域 field 不存在。
		若域 field 已经存在，该操作无效。
		如果 key 不存在，一个新哈希表被创建并执行 HSETNX 命令。*/
		jedis.hsetnx("k1", "website", "baidus.com");
		jedis.hsetnx("k1", "websites", "baidues.com");
		System.out.println(jedis.hget("k1", "website"));
		System.out.println(jedis.hget("k1", "websites"));
		/*同时将多个 field-value (域-值)对设置到哈希表 key 中。
		此命令会覆盖哈希表中已存在的域。
		如果 key 不存在，一个空哈希表被创建并执行 HMSET 操作。*/
		Map<String,String> hash = new HashMap<String,String>();
		hash.put("k3", "v3");
		hash.put("k4", "v4");
		hash.put("k5", "v5");
		jedis.hmset("k2", hash);
		/*返回哈希表 key 中，一个或多个给定域的值。
		如果给定的域不存在于哈希表，那么返回一个 nil 值。
		因为不存在的 key 被当作一个空哈希表来处理，所以对一个不存在的 key 进行 HMGET 操作将返回一个只带有 nil 值的表*/
		System.out.println(jedis.hmget("k2", "k3","k4"));
		/*返回哈希表 key 中，所有的域和值。
		在返回值里，紧跟每个域名(field name)之后是域的值(value)，所以返回值的长度是哈希表大小的两倍。*/
		Map<String, String> hgetAll = jedis.hgetAll("k2");
		Iterator<String> iterator = hgetAll.values().iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			System.out.println(next);
		}
		jedis.close();
	}
	
}
