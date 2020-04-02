package com.example.demo.dao;

import org.springframework.cache.annotation.Cacheable;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月13日
 */

public interface UserinfoDao {
	
	@Cacheable(value = "usercache",keyGenerator="SimpleKey")  
	public String selectUser();
}
