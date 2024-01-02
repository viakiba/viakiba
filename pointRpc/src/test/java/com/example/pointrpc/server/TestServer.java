package com.example.pointrpc.server;

import com.example.pointrpc.common.register.IRegister;
import com.example.pointrpc.common.register.ZKRegister;
import com.example.pointrpc.server.core.IServer;
import com.example.pointrpc.server.core.NettyServer;
import com.example.pointrpc.server.service.ServiceManager;
import com.example.pointrpc.service.ITestService;
import com.example.pointrpc.service.TestService;

public class TestServer {
    public static void main(String[] args) throws Exception {
        // 注册 rpc 服务
        ServiceManager.addService(ITestService.class.getName(), new TestService());
        // 注册 zk
        IRegister register = new ZKRegister("127.0.0.1:2181");
        // 开启 netty 服务
        IServer server = new NettyServer();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                server.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
        server.start(register, "test", "1", "127.0.0.1", "10000");
    }
}
