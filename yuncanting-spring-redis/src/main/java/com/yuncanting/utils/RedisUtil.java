package com.yuncanting.utils;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description 特殊需求的redis存储
 * @Author viakiba
 */
@Component
public class RedisUtil {

    @Resource
    private JedisConnectionFactory redisConnectionFactory;
}
