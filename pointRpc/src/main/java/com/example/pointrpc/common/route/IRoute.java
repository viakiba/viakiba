package com.example.pointrpc.common.route;

import com.example.pointrpc.common.discovery.IDiscovery;
import com.example.pointrpc.common.model.ServerMeta;

public interface IRoute {
    
    void init(IDiscovery discovery);

    ServerMeta chroseServer(String serverId);

}
