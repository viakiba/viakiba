package com.example.pointrpc.service;

public class TestService implements ITestService{

    @Override
    public String testService(String age, int name) {
        return age+name+"res";
    }
    
}
