package com.atguigu.redis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil 
{
	private static volatile JedisPool jedisPool = null;
	
	private JedisPoolUtil(){}
	
	public static JedisPool getJedisPoolInstance()
	{
		if(null == jedisPool)
		{
			synchronized (JedisPoolUtil.class)
			{
				if(null == jedisPool)
				{
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					poolConfig.setMaxActive(1000);
					poolConfig.setMaxIdle(32);
					poolConfig.setMaxWait(100*1000);
					poolConfig.setTestOnBorrow(true);

					jedisPool = new JedisPool(poolConfig,"127.0.0.1",6379);
				}
			}
		}
		return jedisPool;
	}

	public static void release(JedisPool jedisPool,Jedis jedis)
	{
		if(null != jedis)
		{
			jedisPool.returnResourceObject(jedis);
		}
	}
	
}
