package com.viakiba.redis.step10;

import java.util.List;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @description: redis 发布/定阅 相关的演示
 * 					PSUBSCRIBE，PUBLISH,PUNSUBSCRIBE,SUBSCRIBE,UNSUBSCRIBE
 * @author viakiba
 * @date 2017年8月17日
 */
public class App25 {
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
	 * @description: 订阅
	 * 		PUNSUBSCRIBE/PSUBSCRIBE
	 * 		SUBSCRIBE/UNSUBSCRIBE
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		//连接测试是否通过
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		JedisPubSub jedisPubSub = new JedisPubSub() {
			/**
			 * 系统发送一条订阅命令
			 */
			@Override
			public void onSubscribe(String str, int str1) {
				// TODO Auto-generated method stub
				System.out.println("onSubscribe"+str);
			}
			
			/**
			 * str1:本次消息  接受自的频道
			 * str2:本次消息的内容
			 */
			@Override
			public void onMessage(String str, String str1) {
				// TODO Auto-generated method stub
				System.out.println("onMessage"+str+str1);
			}
			
			/**
			 * 关闭此订阅时执行的命令
			 */
			@Override
			public void onUnsubscribe(String str, int str1) {
				// TODO Auto-generated method stub
				System.out.println("onUnsubscribe"+str);
			}
			
			/**
			 * 系统发送一条订阅命令（通配符版本）
			 */
			@Override
			public void onPSubscribe(String str, int str1) {
				// TODO Auto-generated method stub
				System.out.println("onPSubscribe"+str);
			}
			
			/**
			 * str:订阅的频道，支持通配符
			 * str1:本次消息  接受自的频道
			 * str2:本次消息的内容
			 */
			@Override
			public void onPMessage(String str, String str1, String str2) {
				// TODO Auto-generated method stub
				System.out.println("onPMessage"+str+str1+str2);
			}
			
			/**
			 * 关闭此订阅时执行的命令
			 */
			@Override
			public void onPUnsubscribe(String str, int str1) {
				// TODO Auto-generated method stub
				System.out.println("onPUnsubscribe"+str+str1);
			}
		};
		//一个线程只能订阅一个，会被阻塞
//		jedis.subscribe(jedisPubSub, "he");
		jedis.psubscribe(jedisPubSub, "hel*");
		jedis.close();
	}
	
	/**
	 * @description: PUBLISH
	 * 		发布一条消息
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
//		jedis.publish("demo", "haha");
		jedis.close();
	}
	
	/**
	 * PUBSUB:是一个查看订阅与发布系统状态的内省命令， 它由数个不同格式的子命令组成， 以下将分别对这些子命令进行介绍。
	 * 	http://redisdoc.com/pub_sub/pubsub.html
	 */
	@Test
	public void test4() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
	/*
		 列出当前的活跃频道。
		活跃频道指的是那些至少有一个订阅者的频道， 订阅模式的客户端不计算在内。
		pattern 参数是可选的：
		如果不给出 pattern 参数，那么列出订阅与发布系统中的所有活跃频道。
		如果给出 pattern 参数，那么只列出和给定模式 pattern 相匹配的那些活跃频道。
	*/
		List<String> pubsubChannels = jedis.pubsubChannels("");
		System.out.println(pubsubChannels);
		
	/*
		 返回给定频道的订阅者数量， 订阅模式的客户端不计算在内。
	 */
		System.out.println(jedis.pubsubNumPat());
	/*
		 返回订阅模式的数量。
		注意， 这个命令返回的不是订阅模式的客户端的数量， 而是客户端订阅的所有模式的数量总和。
	*/
		System.out.println(jedis.pubsubNumPat());
		jedis.close();
	}
}
