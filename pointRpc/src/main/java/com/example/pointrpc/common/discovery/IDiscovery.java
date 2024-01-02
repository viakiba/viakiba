package com.example.pointrpc.common.discovery;

import java.util.Map;

import com.example.pointrpc.common.model.ServerMeta;

public interface IDiscovery {
    void startDiscovery(String registerAddr,String path);

    Map<String,ServerMeta> getAllEntities();

    ServerMeta getEntity(String serverId);

    void stop();
}
