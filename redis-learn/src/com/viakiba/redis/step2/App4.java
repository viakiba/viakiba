package com.viakiba.redis.step2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @description: 
 * 			关于key的相关操作(3)
 * 			RANDOMKEY,RENAME/RENAMENX，SORT，TYPE，SCAN
 * 			参考：http://redisdoc.com/index.html
 * @author viakiba
 * @date 2017年8月17日
 */
public class App4 {
	
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
	 * @description: randomKey
	 * 				从当前数据库中随机返回(不删除)一个 key 。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushDB();
		jedis.set("k1", "v1");
		jedis.set("k2", "v2");
		jedis.set("k3", "v3");
		jedis.set("k4", "v4");
		String key = jedis.randomKey();
		System.out.println(key+":"+jedis.get(key));
		jedis.close();
	}
	
	/**
	 * @description: RENAME
	 * 				将 key 改名为 newkey 。
	 * 				当 key 和 newkey 相同，或者 key 不存在时，返回一个错误。
	 * 				当 newkey 已经存在时， RENAME 命令将覆盖旧值。
	 * 
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception{
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushDB();
		jedis.set("k1", "v1");
		jedis.set("k2", "v2");
		System.out.println(jedis.rename("k1", "k1"));//当 key 和 newkey 相同，返回ok
//		System.out.println(jedis.rename("k0", "k2"));// key 不存在,会抛出异常 JedisDataException
//		System.out.println(jedis.rename("k0", "k3"));// key 不存在,会抛出异常 JedisDataException
		jedis.rename("k1", "k2");
		System.out.println(jedis.get("k1"));
		System.out.println(jedis.get("k2"));
		jedis.close();
	}
	
	/**
	 * @description: RENAMENX
	 * 				当且仅当 newkey 不存在时，将 key 改名为 newkey 。
	 * 				当 key 不存在时，返回一个错误。
	 * 
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushDB();
		jedis.set("k1", "v1");
		jedis.set("k2", "v2");
		
		//没有key 抛出异常
//		System.out.println(jedis.renamenx("k0", "k2"));
//		System.out.println(jedis.renamenx("k0", "k3"));
		
		//newkey存在  返回0
//		System.out.println(jedis.renamenx("k1", "k2"));
//		System.out.println(jedis.get("k1"));
//		System.out.println(jedis.get("k2"));
		
		//newkey不存在  返回1
		System.out.println(jedis.renamenx("k1", "k3"));
		System.out.println(jedis.get("k1"));
		System.out.println(jedis.get("k2"));
		System.out.println(jedis.get("k3"));
		jedis.close();
	}
	
	/**
	 * @description: SORT
	 * 				返回或保存给定列表、集合、有序集合 key 中经过排序的元素。
	 * 				排序默认以数字作为对象，值被解释为双精度浮点数，然后进行比较。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushDB();
		jedis.lpush("k1","4","3","5");//列表  没有相关的scan
		List<String> sort = jedis.sort("k1");
		for(String str: sort){
			System.out.println(str);
		}
		jedis.close();
	}
	
	/**
	 * @description: TYPE
	 * 				返回 key 所储存的值的类型。
	 * 				none (key不存在)，string (字符串)，list (列表)，set (集合)
	 * 				zset (有序集)，hash (哈希表)
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushDB();
		jedis.set("k1", "v1");
		jedis.lpush("k2", "v2","v3","v4","v5");
		
		System.out.println(jedis.type("k0"));//none (key不存在)
		System.out.println(jedis.type("k1"));//string (字符串)
		System.out.println(jedis.type("k2"));//list (列表)
		jedis.close();
	}
	
	/**
	 * @description: SCAN/SSCAN/HSCAN/ZSCAN
	 * 				将 key 改名为 newkey 。
	 * 				当 key 和 newkey 相同，或者 key 不存在时，返回一个错误。
	 * 				当 newkey 已经存在时， RENAME 命令将覆盖旧值。
	 * 
	 * 		SCAN 命令用于迭代当前数据库中的数据库键。
	 * 		SSCAN 命令用于迭代集合键中的元素。
	 * 		HSCAN 命令用于迭代哈希键中的键值对。
	 * 		ZSCAN 命令用于迭代有序集合中的元素（包括元素成员和元素分值）。
	 * Jedis:未提供相关Api
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test7() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushDB();
		jedis.set("k1", "v1");//字符串
		jedis.set("k2", "v2");//字符串
		jedis.lpush("k3","v3","v4","v5");//列表  没有相关的scan
		jedis.sadd("k4", "k4","k5");//set集合   命令： sscan k4 0
		Map<String,Double> map = new HashMap<String,Double> ();
		map.put("mv1",(double) 1);//key是分数 或者说是权重
		map.put("mv3",(double) 2);//key是分数 或者说是权重
		map.put("mv2",(double) 3);//key是分数 或者说是权重
		jedis.zadd("k5", map);//SortedSet（有序集合）    命令： zscan k5 0
		jedis.hset("k6","y1","v6");//散列  命令：hscan k6 0
		System.out.println("========数据准备完成=======");
		//scan//sscan//hsacn//zscan
		jedis.close();
	}
}
