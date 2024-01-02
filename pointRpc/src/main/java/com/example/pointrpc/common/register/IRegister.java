package com.example.pointrpc.common.register;

public interface IRegister {
    
    void registerServer(String type,String serverId,String host,String port) throws Exception;

    void unRegisterServer() throws Exception;
}
