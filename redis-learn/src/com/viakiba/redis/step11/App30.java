package com.viakiba.redis.step11;

import org.junit.Test;
import redis.clients.jedis.*;
import redis.clients.jedis.JedisMonitor;

/**
 * @description: server相关的命令
 * 		参考：http://redisdoc.com/server/index.html
 * @author viakiba
 * @date 2017年8月18日
 */
public class App30 {
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
	 * @description: sync/PSYNC/SHUTDOWN/SLOWLOG
	 * 		参考：
	 * 			http://redisdoc.com/topic/replication.html#replication-topic
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
//		Sync 命令用于同步主从服务器。
//		jedis.sync();
		
/*		
		停止所有客户端
		如果有至少一个保存点在等待，执行 SAVE 命令
		如果 AOF 选项被打开，更新 AOF 文件
		关闭 redis 服务器(server)
		如果持久化被打开的话， SHUTDOWN 命令会保证服务器正常关闭而不丢失任何数据。
		注意：
			假如只是单纯地执行 SAVE 命令，然后再执行 QUIT 命令，则没有这一保证 —— 因为在执行 SAVE 之后、执行 QUIT 之前的这段时间中间，
			其他客户端可能正在和服务器进行通讯，这时如果执行 QUIT 就会造成数据丢失。
		可选命令：	Jedis中未体现
			执行 SHUTDOWN SAVE 会强制让数据库执行保存操作，即使没有设定(configure)保存点
			执行 SHUTDOWN NOSAVE 会阻止数据库执行保存操作，即使已经设定有一个或多个保存点(你可以将这一用法看作是强制停止服务器的一个假想的 ABORT 命令)
*/
//		jedis.shutdown();
		
//		SLOWLOG  参考：http://redisdoc.com/server/slowlog.html
//		JedisApi: slowlogGetBinary, slowlogGetGet, slowlogLen, slowlogReset
//		List<Slowlog> slowlogGet = jedis.slowlogGet();
//		System.out.println(slowlogGet.get(0).getArgs());
		
	/*slaveof:
		SLAVEOF host port
			通过执行 SLAVEOF host port 命令，可以将当前服务器转变为指定服务器的从属服务器(slave server)。
			如果当前服务器已经是某个主服务器(master server)的从属服务器，那么执行 SLAVEOF host port 将使当前服务器停止对旧主服务器的同步，
			丢弃旧数据集，转而开始对新主服务器进行同步。
		SLAVEOF NO ONE
			对一个从属服务器执行命令 SLAVEOF NO ONE 将使得这个从属服务器关闭复制功能，并从从属服务器转变回主服务器，原来同步所得的数据集不会被丢弃。
			利用『 SLAVEOF NO ONE 不会丢弃同步所得数据集』这个特性，可以在主服务器失败的时候，将从属服务器用作新的主服务器，从而实现无间断运行。
	*/
//		String slaveof = jedis.slaveof("l27.0.0.1", 6380);
//		String slaveofNoOne = jedis.slaveofNoOne();
//		System.out.println(slaveof+slaveofNoOne);
		jedis.close();
	}
	
	/**
	 * 
	 * @description: MONITOR/BGREWRITEAOF/CLIENT KILL(jedis未提供API)/DEBUG OBJECT/DEBUG SEGFAULT
	 * 		
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
		//MONITOR
		jedis.monitor(new JedisMonitor() {//执行此程序后，在新启一个客户端输入命令即可看到效果
			@Override
			public void onCommand(String arg0) {
				System.out.println(arg0);
				
			}
		});
		
//		BGREWRITEAOF:执行一个 AOF文件 重写操作。重写会创建一个当前 AOF 文件的体积优化版本。
//		String bgrewriteaof = jedis.bgrewriteaof();//参考：http://redisdoc.com/server/bgrewriteaof.html
		
	 /*
	  不测试了 参考：
		DEBUG OBJECT ：http://redisdoc.com/server/debug_object.html
		DEBUG SEGFAULT ：http://redisdoc.com/server/debug_segfault.html
	*/ 
		jedis.close();
	}
}
