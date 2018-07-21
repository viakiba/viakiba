package com.viakiba.redis.step8;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @description: HyperLogLog
 * 			PFADD/PFCOUNT/PFMERGE
 * 		参考：
 * 			http://redisdoc.com/hyperloglog/index.html
 * 		介绍：
 * 			它是redis内置的一种数据结构，熟悉命令，在代码结束位置，给具体用例。
 * 			Spring data Redis(依赖Spring core)
 * @author viakiba
 * @date 2017年8月18日
 */
public class App23 {
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
	 * @description: PFADD/PFCOUNT/PFMERGE
	 * 		参考:
	 * 			http://aiilive.blog.51cto.com/1925756/1627455
	 * 
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
	/*
		 将任意数量的元素添加到指定的 HyperLogLog 里面。
		作为这个命令的副作用， HyperLogLog 内部可能会被更新， 以便反映一个不同的唯一元素估计数量（也即是集合的基数）。
		如果 HyperLogLog 估计的近似基数（approximated cardinality）在命令执行之后出现了变化， 那么命令返回 1 ， 否则返回 0 。
		如果命令执行时给定的键不存在， 那么程序将先创建一个空的 HyperLogLog 结构， 然后再执行命令。
		调用 PFADD 命令时可以只给定键名而不给定元素：
		如果给定键已经是一个 HyperLogLog ， 那么这种调用不会产生任何效果；
		但如果给定的键不存在， 那么命令会创建一个空的 HyperLogLog ， 并向客户端返回 1 。
	*/
//		Long pfadd = jedis.pfadd("h1", "a","b","a","c","a","d","a","e");
//		Long pfadd1 = jedis.pfadd("h1", "a","b","a","c","a","d","a","e");
//		System.out.println(pfadd+":"+pfadd1);//key不存在返回1，存在返回0
		
	/*
		当 PFCOUNT 命令作用于单个键时， 返回储存在给定键的 HyperLogLog 的近似基数， 如果键不存在， 那么返回 0 。
		当 PFCOUNT 命令作用于多个键时， 返回所有给定 HyperLogLog 的并集的近似基数， 这个近似基数是通过将所有给定 HyperLogLog 合并至一个临时 HyperLogLog 来计算得出的。
		通过 HyperLogLog 数据结构， 用户可以使用少量固定大小的内存， 来储存集合中的唯一元素 （每个 HyperLogLog 只需使用 12k 字节内存，以及几个字节的内存来储存键本身）。
		命令返回的可见集合（observed set）基数并不是精确值， 而是一个带有 0.81% 标准错误（standard error）的近似值。
	*/
//		long pfcount = jedis.pfcount("h1");
//		long pfcount1 = jedis.pfcount("h2");
//		long pfcount2 = jedis.pfcount("h1","h2");
//		System.out.println(pfcount+":"+pfcount1+":"+pfcount2);
		
	/*
		 将多个 HyperLogLog 合并（merge）为一个 HyperLogLog ， 合并后的 HyperLogLog 的基数接近于所有输入 HyperLogLog 的可见集合（observed set）的并集。
		合并得出的 HyperLogLog 会被储存在 destkey 键里面， 如果该键并不存在， 那么命令在执行之前， 会先为该键创建一个空的 HyperLogLog 。
	 */
		String pfmerge = jedis.pfmerge("h1", "h1","h2");
		System.out.println(pfmerge);
		jedis.close();
	}
	
	/*
	 	经过上述效果演示，这种数据结构被应用在一个典型场景，网站每天的独立IP访问量。
			集合实现：
				使用集合来储存每个访客的 IP ，通过集合性质（集合中的每个元素都各不相同）来得到多个独立 IP ，
				然后通过调用 SCARD 命令来得出独立 IP 的数量。
				举个例子，程序可以使用以下代码来记录 2014 年 8 月 15 日，每个网站访客的 IP ：
				ip = get_vistor_ip()
				SADD '2014.8.15::unique::ip' ip
				然后使用以下代码来获得当天的唯一 IP 数量：
				SCARD '2014.8.15::unique::ip'
			集合实现的问题
				使用字符串来储存每个 IPv4 地址最多需要耗费 15 字节（格式为 'XXX.XXX.XXX.XXX' ，比如
				'202.189.128.186'）。
				下表给出了使用集合记录不同数量的独立 IP 时，需要耗费的内存数量：
				独立 IP 数量一天一个月一年
				一百万15 MB 450 MB 5.4 GB
				一千万150 MB 4.5 GB 54 GB
				一亿1.5 GB 45 GB 540 GB
				随着集合记录的 IP 越来越多，消耗的内存也会越来越多。
				另外如果要储存 IPv6 地址的话，需要的内存还会更多一些
			
		为了更好地解决像独立 IP 地址计算这种问题，
		Redis 在 2.8.9 版本添加了 HyperLogLog 结构。
		HyperLogLog介绍
			HyperLogLog 可以接受多个元素作为输入，并给出输入元素的基数估算值：
			• 基数：集合中不同元素的数量。比如 {'apple', 'banana', 'cherry', 'banana', 'apple'} 的基数就是 3 。
			• 估算值：算法给出的基数并不是精确的，可能会比实际稍微多一些或者稍微少一些，但会控制在合
				理的范围之内。
				HyperLogLog 的优点是，即使输入元素的数量或者体积非常非常大，计算基数所需的空间总是固定
				的、并且是很小的。
				在 Redis 里面，每个 HyperLogLog 键只需要花费 12 KB 内存，就可以计算接近 2^64 个不同元素的基
				数。这和计算基数时，元素越多耗费内存就越多的集合形成鲜明对比。
				但是，因为 HyperLogLog 只会根据输入元素来计算基数，而不会储存输入元素本身，所以
				HyperLogLog 不能像集合那样，返回输入的各个元素。
		参考：
			http://www.cnblogs.com/ysuzhaixuefei/p/4052110.html
	 */
}
