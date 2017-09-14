package com.yuncanting.utils;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * @Description 缓存的key生成策略
 * @Author viakiba
 */
public class SimpleKey implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder sb = new StringBuilder();
        String classname = target.getClass().getName();
        sb.append(classname);
        sb.append(method.getName());
        for (Object obj : params) {
            sb.append(obj.toString());
        }
        return sb.toString();
    }
}
