package com.viakiba.redis.step4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;

public class App11 {
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
	 * @description: HEXISTS/HKEYS/HVALS
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		jedis.flushAll();
		Map<String,String> hash = new HashMap<String,String>();
		hash.put("k3", "v3");
		hash.put("k4", "v4");
		hash.put("k5", "v5");
		jedis.hmset("k2", hash);
		
		List<String> hvals = jedis.hvals("k2");
		System.out.println(hvals);
		Set<String> hkeys = jedis.hkeys("k2");
		System.out.println(hkeys);
		
		Boolean hexists = jedis.hexists("k2", "k3");
		Boolean hexistss = jedis.hexists("k2", "k6");
		System.out.println(hexists+":"+hexistss);
		jedis.close();
	}
	
	/**
	 * @description: HLEN/HSTRLEN/HSCAN
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		jedis.flushAll();
		Map<String,String> hash = new HashMap<String,String>();
		hash.put("k3", "v3");
		hash.put("k4", "v4");
		hash.put("k5", "v55");
		jedis.hmset("k2", hash);
		
		Long hlen = jedis.hlen("k2");
		System.out.println(hlen);
		
		/*HSTRLEN key field
		返回哈希表 key 中， 与给定域 field 相关联的值的字符串长度（string length）。
		如果给定的键或者域不存在， 那么命令返回 0 。*/
		
//		HSCAN 命令用于迭代哈希键中的键值对   此api存在bug不建议使用在 jedis 2.9 版本之前
		@SuppressWarnings("deprecation")
		ScanResult<Entry<String, String>> hscan = jedis.hscan("k2", 1);
		List<Entry<String, String>> result = hscan.getResult();
		System.out.println(result);
		jedis.close();
	}
}
