package com.yuncanting.service;

import com.yuncanting.entity.TestEntity;
import org.springframework.cache.annotation.Cacheable;

import java.util.Map;

/**
 * @Description
 * @Author viakiba
 * @Date ${date}
 */
public interface TestService {


    public TestEntity queryMethod(String name);

}
