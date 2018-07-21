package com.viakiba.redis.step11;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @description: Server相关的命令
 * 		参考：http://redisdoc.com/server/index.html
 * @author viakiba
 * @date 2017年8月18日
 */
public class App29 {
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
	 * @description: info/CONFIG GET/CONFIG SET/CONFIG RESETSTAT/CONFIG REWRITE(未发现API)/bgsave/lastsave/TIME(无API)/dbSize/
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
//		System.out.println(jedis.info());//获取server消息
		
//		CONFIG GET 命令用于取得运行中的 Redis 服务器的配置参数(configuration parameters)
//		CONFIG GET 接受单个参数 parameter 作为搜索关键字，查找所有匹配的配置参数，其中参数和值以“键-值对”(key-value pairs)的方式排列
//		System.out.println(jedis.configGet("slave-serve-stale-data"));
//		System.out.println(jedis.configGet("slave*"));
		
//		CONFIG SET 命令可以动态地调整 Redis 服务器的配置(configuration)而无须重启。
//		你可以使用它修改配置参数，或者改变 Redis 的持久化(Persistence)方式。
//		例如设置慢查询条数
//		System.out.println(jedis.configSet("slowlog-max-len", "1024"));
//		System.out.println(jedis.configGet("slowlog-max-len"));
//		System.out.println(jedis.configSet("slowlog-max-len", "2048"));
//		System.out.println(jedis.configGet("slowlog-max-len"));
		
//		重置 INFO 命令中的某些统计数据  具体请参考：http://redisdoc.com/server/config_resetstat.html
//		String configResetStat = jedis.configResetStat();
		
//		System.out.println(jedis.bgsave());//在后台异步(Asynchronously)保存当前数据库的数据到磁盘。
		
//		System.out.println((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(Long.valueOf(jedis.lastsave()+"000")));
//		jedis.lastsave() 秒级时间戳  返回最近一次 Redis 成功将数据保存到磁盘上的时间，以 UNIX 时间戳格式表示。，拼接3个0编程毫秒级
		
//		System.out.println(jedis.dbSize());//返回当前数据库的 key 的数量。
		jedis.close();
	}
	
	/**
	 * @description: SAVE/CLIENT LIST(无API)/CLIENT SETNAME(无API)/CLIENT GETNAME(无API)
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		//save 执行一个同步保存操作，将当前 Redis 实例的所有数据快照(snapshot)以 RDB 文件的形式保存到硬盘。
		/*
		 	一般来说，在生产环境很少执行 SAVE 操作，因为它会阻塞所有客户端，保存数据库的任务通常由 BGSAVE 命令异步地执行。
		 	然而，如果负责保存数据的后台子进程不幸出现问题时， SAVE 可以作为保存数据的最后手段来使用。
		 */
		System.out.println(jedis.save());
		
//		CLIENT LIST  以人类可读的格式，返回所有连接到服务器的客户端信息和统计数据。
//		CLIENT SETNAME 为当前连接分配一个名字。这个名字会显示在 CLIENT LIST 命令的结果中， 用于识别当前正在与服务器进行连接的客户端。
//		CLIENT GETNAME 返回 CLIENT SETNAME 命令为连接设置的名字。
		jedis.close();
	}
}
