package com.example.pointrpc.proxy;

import com.example.pointrpc.client.connect.RpcClient;
import com.example.pointrpc.service.ITestService;

public class TestProxyJdk {

    public static void main(String[] args) {
       ITestService newProxyInstance = RpcClient.getService(ITestService.class,1);
       String testService = newProxyInstance.testService("xx", 1);
       System.out.println(testService);
    }
}