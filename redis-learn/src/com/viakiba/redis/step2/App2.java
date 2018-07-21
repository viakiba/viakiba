package com.viakiba.redis.step2;

import java.util.Set;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @description: 
 * 		关于key的相关操作(1)
 * 			DUMP/RESTORE，EXISTS，EXPIRE/EXPIREAT，KEYS
 * 			
 * 		参考：http://redisdoc.com/index.html
 * @author viakiba
 * @date 2017年8月17日
 */
public class App2 {
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
	 * @description: DUMP/RESTORE
	 * 		序列化给定 key ，并返回被序列化的值，使用 RESTORE 命令可以将这个值反序列化为 Redis 键。
	 * 		序列化生成的值有以下几个特点：
	 * 			它带有 64 位的校验和，用于检测错误， RESTORE 在进行反序列化之前会先检查校验和。
	 * 			值的编码格式和 RDB 文件保持一致。
	 * 			RDB 版本会被编码在序列化值当中，如果因为 Redis 的版本不同造成 RDB 格式不兼容，那么 Redis 会拒绝对这个值进行反序列化操作。
	 * 		序列化的值不包括任何生存时间信息。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		//jedis没有相关的api  可以使用其他类过滤支持 StringRedisSerializer(Spring支持的)
		//参考   https://github.com/viakiba/springboot/tree/master/springbootredis
	}
	
	/**
	 * @description: EXISTS  检查给定 key 是否存在。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushDB();
		jedis.set("k1", "v1");
		System.out.println(jedis.exists("k1")+"存在");
		System.out.println(jedis.exists("k2")+"存在");
		jedis.close();
	}
	
	/**
	 * @description: EXPIRE：
	 * 						为给定 key 设置生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除。
	 * 						可以对一个已经带有生存时间的 key 执行 EXPIRE 命令，新指定的生存时间会取代旧的生存时间。
	 * 				 EXPIREAT:
	 * 						EXPIREAT 的作用和 EXPIRE 类似，都用于为 key 设置生存时间。
	 * 						不同在于 EXPIREAT 命令接受的时间参数是 UNIX 时间戳(unix timestamp)。
	 * 				  扩展：
	 * 						在 Redis 中，带有生存时间的 key 被称为『易失的』(volatile)。
	 * 						生存时间可以通过使用 DEL 命令来删除整个 key 来移除，或者被 SET 和 GETSET 命令覆写(overwrite)，这意味着，
	 * 						如果一个命令只是修改(alter)一个带生存时间的 key 的值而不是用一个新的 key 值来代替(replace)它的话，那么生存时间不会被改变。
	 * 						比如说，对一个 key 执行 INCR 命令，对一个列表进行 LPUSH 命令，或者对一个哈希表执行 HSET 命令，这类操作都不会修改 key 本身的生存时间。
	 * 						另一方面，如果使用 RENAME 对一个 key 进行改名，那么改名后的 key 的生存时间和改名前一样。
	 * 						RENAME 命令的另一种可能是，尝试将一个带生存时间的 key 改名成另一个带生存时间的 another_key ，这时旧的 another_key (以及它的生存时间)会被删除，
	 * 						然后旧的 key 会改名为 another_key ，因此，新的 another_key 的生存时间也和原本的 key 一样。
	 * 						使用 PERSIST 命令可以在不删除 key 的情况下，移除 key 的生存时间，让 key 重新成为一个『持久的』(persistent) key 。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushDB();
		jedis.set("k1", "v1");
		System.out.println(jedis.exists("k1")+"存在");
		//设置成功返回 1 。
		//当 key 不存在或者不能为 key 设置生存时间时(比如在低于 2.1.3 版本的 Redis 中你尝试更新 key 的生存时间)，返回 0 。
		jedis.expire("k1",3);
		System.out.println(jedis.exists("k1")+"存在");
		Thread.sleep(4000);
		System.out.println("4s后"+jedis.exists("k1")+"存在");
		//EXPIREAT  expireAt()  不再演示
		jedis.close();
	}
	
	/**
	 * @description: keys:
	 * 					查找所有符合给定模式 pattern 的 key 。
	 * 						KEYS * 匹配数据库中所有 key 。
	 * 						KEYS h?llo 匹配 hello ， hallo 和 hxllo 等。
	 * 						KEYS h*llo 匹配 hllo 和 heeeeello 等。
	 * 						KEYS h[ae]llo 匹配 hello 和 hallo ，但不匹配 hillo 。
	 * 						特殊符号用 \ 隔开
	 * 					KEYS 的速度非常快，但在一个大的数据库中使用它仍然可能造成性能问题，如果你需要从一个数据集中查找特定的 key ，你最好还是用 Redis 的集合结构(set)来代替。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.flushDB();
		jedis.set("h", "h");
		jedis.set("he", "he");
		jedis.set("hel", "hel");
		jedis.set("hell", "hell");
		jedis.set("hello", "hello");
		System.out.println("=====构造数据=====");
		
//		Set<String> keys = jedis.keys("*");//所有
//		Set<String> keys = jedis.keys("h?");//he
//		Set<String> keys = jedis.keys("h*l");//hel hell
		Set<String> keys = jedis.keys("h[ae]l");//hel hell
		for(String key : keys){
			System.out.println("key:"+key+"&"+"value"+":"+jedis.get(key));
		}
		jedis.close();
	}
}
