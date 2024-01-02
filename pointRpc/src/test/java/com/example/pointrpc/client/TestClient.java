package com.example.pointrpc.client;

import com.example.pointrpc.client.connect.RpcClient;
import com.example.pointrpc.service.ITestService;

public class TestClient {
    public static void main(String[] args) throws InterruptedException {
        RpcClient.getInstance().init();
        Thread.sleep(3000);
        ITestService service = RpcClient.getService(ITestService.class, 1);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            String testService = service.testService("ddddd", 0);
            System.out.println(testService);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }
}
