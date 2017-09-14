package com.yuncanting.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Description
 * @Author viakiba
 * @Date ${date}
 */
@Repository
public interface TestEntityDao {

    @Cacheable(value = "test",keyGenerator = "SimpleKey",cacheManager = "cacheManager")
    public Map queryOne(String name);

    @Cacheable(value = "tests",keyGenerator = "SimpleKey",cacheManager = "cacheManagers")
    public Map queryOnes(String name);
}
