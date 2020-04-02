package com.example.demo.test;

import redis.clients.jedis.Jedis;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月12日
 */

public class TestRedis {
	public static void main(String[] args) {
		System.out.println("连接中。。。。。。");
		//连接本地的 Redis 服务
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
	}
}
