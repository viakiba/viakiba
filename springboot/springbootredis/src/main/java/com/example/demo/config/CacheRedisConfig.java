package com.example.demo.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCacheManager;  
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;  
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method; 
@Configuration  
@EnableCaching  
public class CacheRedisConfig extends CachingConfigurerSupport{  
  
	@Autowired
    private JedisConnectionFactory jedisConnectionFactory;
	
	@Bean(name = "SimpleKey")
	public KeyGenerator getKeyGenerator(){
		return new KeyGenerator() {  
          @Override  
          public Object generate(Object target, Method method, Object... params) {  
              StringBuilder sb = new StringBuilder();  
              sb.append(target.getClass().getName());  
              sb.append(method.getName());  
              for (Object obj : params) {  
                  sb.append(obj.toString());  
              }
              System.out.println(sb.toString());
              return sb.toString();  
          }  
      }; 
	}
    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
        return redisCacheManager;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
       
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        // 开启事务支持
        redisTemplate.setEnableTransactionSupport(true);
        // 使用String格式序列化缓存键
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
        
        return redisTemplate;
    } 
}  