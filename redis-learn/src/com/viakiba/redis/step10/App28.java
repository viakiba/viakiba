package com.viakiba.redis.step10;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @description: Connection（连接）
 * 		参考：http://redisdoc.com/connection/index.html
 * 		AUTH,ECHO,PING,QUIT,SELECT
 * @author viakiba
 * @date 2017年8月17日
 */
public class App28 {
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
	 * 			AUTH
	 * 					通过设置配置文件中 requirepass 项的值(使用命令 CONFIG SET requirepass password )，可以使用密码来保护 Redis 服务器。
	 * 					如果开启了密码保护的话，在每次连接 Redis 服务器之后，就要使用 AUTH 命令解锁，解锁之后才能使用其他 Redis 命令。
	 * 					如果 AUTH 命令给定的密码 password 和配置文件中的密码相符的话，服务器会返回 OK 并开始接受命令输入。
	 * 					另一方面，假如密码不匹配的话，服务器将返回一个错误，并要求客户端需重新输入密码。
	 * 				 注意：
	 * 					因为 Redis 高性能的特点，在很短时间内尝试猜测非常多个密码是有可能的，因此请确保使用的密码足够复杂和足够长，以免遭受密码猜测攻击。
	 * 					一般redis都是部署在内网
	 * 				提示：
	 * 					 CONFIG SET requirepass 你的redis服务器密码    在客户端通过此命令设置服务器密码
	 * 					 ex:  CONFIG SET requirepass 123456
	 * 			PING
	 * 					使用客户端向 Redis 服务器发送一个 PING ，如果服务器运作正常的话，会返回一个 PONG 。
	 * 					通常用于测试与服务器的连接是否仍然生效，或者用于测量延迟值。
	 * 			ECHO
	 * 					打印一个特定的信息 message ，测试时使用。
	 * 			QUIT
	 * 					请求服务器关闭与当前客户端的连接。
	 * 					一旦所有等待中的回复(如果有的话)顺利写入到客户端，连接就会被关闭。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis("127.0.0.1",RedisConfig.PORT);
//		jedis.ping();//未认证回报错
		jedis.auth("密码");
		System.out.println(jedis.ping());
		//原文回显 一般用于测试
		String echo = jedis.echo("hello world");
		System.out.println(echo);
		System.out.println(jedis.quit());
//		System.out.println(jedis.ping());//退出后执行会报错
		jedis.close();
	}
}
