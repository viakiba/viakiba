package com.example.pointrpc.register;

import org.junit.jupiter.api.Test;

import com.example.pointrpc.common.constant.Constant;
import com.example.pointrpc.common.discovery.ZKDiscovery;
import com.example.pointrpc.common.register.ZKRegister;

public class Test1 {
    static String addr = "127.0.0.1:2181";
    @Test
    public void test1() throws Exception{
        ZKRegister zkRegister = new ZKRegister(addr);
        zkRegister.registerServer("null", "1", "null", "null");
        while (true) {
        }
    }

    public static void main(String[] args) throws Exception {
        ZKDiscovery zkDiscovery = new ZKDiscovery();
        zkDiscovery.startDiscovery(addr,Constant.DEFAULT_PATH);
        while (true) {
            
        }
    }
}
