package com.viakiba.redis.step1;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @description: 
 * 			最新的Redis 2.6 测试，建议上机测试
 * 			这些命令是最基本的命令，在这些已知的基础上，才能进行接下来的命令的选择性了解
 * 			set/get/dbsize/select/flushAll/flushdb/del
 * 			jedisApi: http://tool.oschina.net/uploads/apidocs/ 
 * 			接下来的代码，请务必在自己全新的redis数据库进行测试，不要在生产环境中测试！！！！
 * 参考：http://redisdoc.com/index.html
 * @author viakiba
 * @date 2017年8月17日
 */
public class App1 {
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
	 * @description: set/get 命令
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		/**
		 * set
		 * 将字符串值 value 关联到 key 。
		 * 如果 key 已经持有其他值， SET 就覆写旧值，无视类型。
		 * 对于某个原本带有生存时间（TTL）的键来说， 当 SET 命令成功在这个键上执行时， 这个键原有的 TTL 将被清除。
		 * 可选参数：
		 * 		EX second ：设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key second value 。
		 * 		PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX millisecond 效果等同于 PSETEX key millisecond value 。
		 * 		NX ：只在键不存在时，才对键进行设置操作。 SET key value NX 效果等同于 SETNX key value 。
		 * 		XX ：只在键已经存在时，才对键进行设置操作。
		 */
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		System.out.println(jedis.set("k1", "v1"));//ok
		
		/**
		 * get返回 key 所关联的字符串值。
		 * 		如果 key 不存在那么返回特殊值 nil 。
		 * 		假如 key 储存的值不是字符串类型，返回一个错误，因为 GET 只能用于处理字符串值。
		 */
		System.out.println(jedis.get("k1"));//v1
		System.out.println(jedis.get("k2"));//null
		
		jedis.close();
	}
	
		/**
		 * @description: 对于set可选参数的测试 EX/NX
		 * @author: viakiba
		 * @throws Exception
		 */
		@Test
		public void test2_1() throws Exception {
			Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
			//System.out.println(jedis.flushAll());  //清空所有数据
			
			//可选参数EX
//			System.out.println(jedis.setex("k1", 5, "v1"));//5s失效
//			System.out.println("失效前"+jedis.get("k1"));
//			Thread.sleep(6000);//睡6秒就到时间了
//			System.out.println("失效后"+jedis.get("k1"));
			
			//可选参数NX  只在键不存在时，才对键进行设置操作
//			System.out.println(jedis.flushAll());//清空所有数据
//			jedis.set("k1", "v1");
//			System.out.println("前"+jedis.get("k1"));
//			System.out.println(jedis.setnx("k1", "v2"));//此时 k1 是存在的，值为 v1
//			System.out.println(jedis.setnx("k2", "v2"));//此时 k2是不存在的
//			System.out.println("k1后"+jedis.get("k1"));//k1 上述操作无影响
//			System.out.println("k2后"+jedis.get("k2"));//k2 上述操作有影响
			
			jedis.close();
		}
		
	/**
	 * @description: flushAll/select
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		//flushAll  清空整个 Redis 服务器的数据(删除所有数据库的所有 key )。
		System.out.println(jedis.flushAll());
		System.out.println("==========清除数据===========");
		//select 切换到指定的数据库，数据库索引号 index 用数字值指定，以 0 作为起始索引值。默认使用 0 号数据库。
		System.out.println(jedis.select(0));
		System.out.println("==========选择DB===========");
		System.out.println(jedis.set("k1", "v1"));//ok
		System.out.println(jedis.select(1));
		System.out.println(jedis.set("k2", "v2"));//ok
		System.out.println("==========装入数据===========");
		System.out.println(jedis.select(0));
		System.out.println("==========选择DB===========");
		System.out.println(jedis.get("k1"));//v1
		System.out.println(jedis.select(1));
		System.out.println("==========选择DB===========");
		System.out.println(jedis.get("k2"));//v2
		System.out.println("==========查看数据===========");
		//flushAll  清空整个 Redis 服务器的数据(删除所有数据库的所有 key )。
		System.out.println(jedis.flushAll());
		System.out.println("==========清除数据===========");
		System.out.println(jedis.select(0));
		System.out.println("==========选择DB===========");
		System.out.println(jedis.get("k1"));//null
		System.out.println(jedis.select(1));
		System.out.println("==========选择DB===========");
		System.out.println(jedis.get("k2"));//null
		System.out.println("==========查看数据===========");
		
		jedis.close();
	}
	
	
	/**
	 * @description: bdsize/flushDB
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
//		System.out.println(jedis.flushAll());
//		//bdsize: 返回当前数据库的 key 的数量。
//		System.out.println(jedis.select(0));
//		System.out.println(jedis.dbSize());
//		System.out.println(jedis.setex("k1", 3, "v1"));
//		System.out.println(jedis.dbSize());
//		Thread.sleep(5000);
//		System.out.println(jedis.dbSize());
		
		System.out.println(jedis.flushAll());
		
		System.out.println(jedis.select(0));
		System.out.println(jedis.dbSize());
		System.out.println(jedis.set("k1", "v1"));
		System.out.println(jedis.dbSize());
		
		System.out.println(jedis.select(1));
		System.out.println(jedis.set("k2", "v2"));
		System.out.println(jedis.dbSize());
		System.out.println("============前置准备============");
		System.out.println(jedis.select(1));//清空index为1的数据库
		//flushDB   清空当前数据库中的所有 key。
		System.out.println(jedis.flushDB());
		System.out.println("============flushDB>>1============");
		System.out.println(jedis.select(0));
		System.out.println(jedis.dbSize());
		System.out.println(jedis.select(1));
		System.out.println(jedis.dbSize());
		
		jedis.close();
	}

	/**
	 * @description: del
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		System.out.println(jedis.flushAll());
		
		System.out.println(jedis.dbSize());
		System.out.println(jedis.set("k1", "v1"));
		System.out.println(jedis.set("k2", "v2"));
		System.out.println(jedis.set("k3", "v3"));
		System.out.println(jedis.dbSize());
		System.out.println("=======装入数据已经完成========");
		//del  删除给定的一个或多个 key 。不存在的 key 会被忽略。
		System.out.println(jedis.del("k1"));//返回影响的key的数量  1 存在此key，被删除 /0 不存在此key
		System.out.println(jedis.dbSize()); 
		System.out.println("删除k1");
		System.out.println(jedis.del("k1"));
		System.out.println(jedis.dbSize());
		System.out.println("删除k1");
		
		System.out.println(jedis.del("k2","k3"));//可变参数  可以多个
		System.out.println(jedis.dbSize());
		
		jedis.close();
	}
}
