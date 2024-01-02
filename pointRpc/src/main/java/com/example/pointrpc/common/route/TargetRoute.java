package com.example.pointrpc.common.route;

import com.example.pointrpc.common.discovery.IDiscovery;
import com.example.pointrpc.common.model.ServerMeta;

public class TargetRoute implements IRoute{
    private IDiscovery discovery;
    @Override
    public void init(IDiscovery discovery) {
       this.discovery = discovery;
    }

    @Override
    public ServerMeta chroseServer(String serverId) {
        return discovery.getEntity(serverId);
    }
    
}
