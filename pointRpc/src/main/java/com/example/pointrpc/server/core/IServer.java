package com.example.pointrpc.server.core;

import com.example.pointrpc.common.register.IRegister;

public interface IServer {
    public abstract void start(IRegister register,String regServerType,String serverId,String regHost,String regPort) throws Exception;
    public abstract void stop() throws Exception;
}
