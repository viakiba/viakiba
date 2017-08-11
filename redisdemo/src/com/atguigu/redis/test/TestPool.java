package com.atguigu.redis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestPool {

	public static void main(String[] args) {
		JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
		JedisPool jedisPool2 = JedisPoolUtil.getJedisPoolInstance();
		
		System.out.println(jedisPool == jedisPool2);
		
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set("aa","bb");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JedisPoolUtil.release(jedisPool, jedis);
		}
	}
}
