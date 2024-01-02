package com.example.pointrpc.server.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceManager {
    private static final Map<String,Object> serviceMap = new ConcurrentHashMap<>();

    public static void addService(String className,Object service){
        serviceMap.put(className, service);
    }

     public static Object getService(String serverKey){
        return serviceMap.get(serverKey);
    }
}
