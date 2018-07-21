package com.viakiba.redis.step2;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @description: 
 * 			关于key的相关操作(2)
 * 			MIGRATE，MOVE，OBJECT，PERSIST/PEXPIRE/PEXPIREAT，PTTL/TTL
 * 			
 * 			参考：http://redisdoc.com/index.html
 * @author viakiba
 * @date 2017年8月17日
 */
public class App3 {
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
	 * @description: MIGRATE
	 * 				 将 key 原子性地从当前实例传送到目标实例的指定数据库上，一旦传送成功， 
	 * 				 key 保证会出现在目标实例上，而当前实例上的 key 会被删除。
	 * 				注意：
	 * 				这个命令是一个原子操作，它在执行的时候会阻塞进行迁移的两个实例，
	 * 				直到以下任意结果发生：迁移成功，迁移失败，等待超时。
	 * 参考：
	 * 				http://redisdoc.com/key/migrate.html
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		//jedis不存在该命令
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();
		jedis.close();
	}
	
	/**
	 * @description: MOVE
	 * 					将当前数据库的 key 移动到给定的数据库 db 当中。
	 * 				 注意：
	 * 					如果当前数据库(源数据库)和给定数据库(目标数据库)有相同名字的给定 key ，
	 * 					或者 key 不存在于当前数据库，那么 MOVE 没有任何效果。
	 * 				 	因此，也可以利用这一特性，将 MOVE 当作锁(locking)原语(primitive)。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();//清空所有数据
		System.out.println("=====准备数据=========");
		jedis.set("k1", "v1");//默认选择index为0的数据库
		System.out.println("index0===>"+jedis.get("k1"));
		jedis.select(1);
		System.out.println("index1===>"+jedis.get("k1"));
		System.out.println("======执行move======");
		jedis.select(0);
		jedis.move("k1", 1);
		System.out.println("======查看结果======");
		System.out.println("index0===>"+jedis.get("k1"));
		jedis.select(1);
		System.out.println("index1===>"+jedis.get("k1"));
		jedis.close();
	}
	
	/**
	 * @description: OBJECT
	 * 				 	OBJECT 命令允许从内部察看给定 key 的 Redis 对象。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
//		jedis.flushAll();//清空所有数据
//		System.out.println("=====准备数据=========");
//		jedis.set("k1", "v1");//默认选择index为0的数据库
		
		//OBJECT REFCOUNT <key> 返回给定 key 引用所储存的值的次数。此命令主要用于除错
//		Long objectRefcount = jedis.objectRefcount("k1");
//		System.out.println(objectRefcount);
		//OBJECT ENCODING <key> 返回给定 key 锁储存的值所使用的内部表示(representation)。
		//个人理解 编码方式 embstr  这与value有关 编码有多种
		/*
		 	字符串可以被编码为 raw (一般字符串)或 int (为了节约内存，Redis 会将字符串表示的 64 位有符号整数编码为整数来进行储存）。
			列表可以被编码为 ziplist 或 linkedlist 。 ziplist 是为节约大小较小的列表空间而作的特殊表示。
			集合可以被编码为 intset 或者 hashtable 。 intset 是只储存数字的小集合的特殊表示。
			哈希表可以编码为 zipmap 或者 hashtable 。 zipmap 是小哈希表的特殊表示。
			有序集合可以被编码为 ziplist 或者 skiplist 格式。 ziplist 用于表示小的有序集合，而 skiplist 则用于表示任何大小的有序集合。
		 */
//		String objectEncoding = jedis.objectEncoding("k1");
//		System.out.println(objectEncoding);
		//OBJECT IDLETIME <key> 返回给定 key 自储存以来的空闲时间(idle， 没有被读取也没有被写入)，以秒为单位。
		Long objectIdletime = jedis.objectIdletime("k1");
		System.out.println(objectIdletime);//单位是秒
		jedis.close();
	}
	
	/**
	 * @description: PTTL/TTL
	 * 				TTL:以秒为单位，返回给定 key 的剩余生存时间(TTL, time to live)。
	 * 				PTTL:这个命令类似于 TTL 命令，但它以毫秒为单位返回 key 的剩余生存时间，而不是像 TTL 命令那样，以秒为单位。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushAll();//清空所有数据
		System.out.println("=====准备数据=========");
		jedis.set("k0", "v0");//默认选择index为0的数据库
		jedis.setex("k1", 5, "v1");//默认选择index为0的数据库
		Thread.sleep(3000);
		/**
		 	当 key 不存在时，返回 -2 。
			当 key 存在但没有设置剩余生存时间时，返回 -1 。
			否则，以秒为单位，返回 key 的剩余生存时间。
		 */
		System.out.println(jedis.ttl("k2"));//秒级，另外pttl()jedis没有提供
		System.out.println(jedis.ttl("k0"));//秒级，另外pttl()jedis没有提供
		System.out.println(jedis.ttl("k1"));//秒级，另外pttl()jedis没有提供
		jedis.close();
	}
	
	/**
	 * @description: PEXPIRE/PEXPIREAT/PERSIST
	 * 				PERSIST:移除给定 key 的生存时间，将这个 key 从『易失的』(带生存时间 key )转换成『持久的』(一个不带生存时间、永不过期的 key )。
	 * 				PEXPIREAT:这个命令和 EXPIREAT 命令类似，但它以毫秒为单位设置 key 的过期 unix 时间戳，而不是像 EXPIREAT 那样，以秒为单位。
	 * 				PEXPIRE:这个命令和 EXPIRE 命令的作用类似，但是它以毫秒为单位设置 key 的生存时间，而不像 EXPIRE 命令那样，以秒为单位。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception {
//		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
//		jedis.flushAll();//清空所有数据
//		System.out.println("=====准备数据=========");
//		jedis.setex("k0", 10, "v0");//默认选择index为0的数据库
//		System.out.println(jedis.ttl("k0"));
//		jedis.persist("k0");
//		System.out.println("===========");
//		System.out.println(jedis.ttl("k0"));
//		jedis.close();
	}
}