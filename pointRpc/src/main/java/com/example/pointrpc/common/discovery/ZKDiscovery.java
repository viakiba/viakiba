package com.example.pointrpc.common.discovery;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.retry.RetryOneTime;

import com.example.pointrpc.common.constant.Constant;
import com.example.pointrpc.common.model.ServerMeta;
import com.example.pointrpc.common.utils.JsonUtil;

public class ZKDiscovery implements IDiscovery{
    private CuratorFramework zkClient;
    private String path;
    private CuratorCache curatorCache;

    Map<String, ServerMeta> entities = new HashMap<>();
    
    public void startDiscovery(String registerAddr,String path){
        CuratorFramework zkClient = CuratorFrameworkFactory.newClient(registerAddr, 5000, 5000, new RetryOneTime(3000));
        zkClient.start();
        this.zkClient = zkClient;
        this.path = path;

        curatorCache = CuratorCache.build(this.zkClient, this.path);
        curatorCache.listenable().addListener(new CuratorCacheListener() {
            @Override
            public void event(Type type, ChildData oldData, ChildData data) {
                String path = data.getPath();
                if(path.endsWith(Constant.DEFAULT_PATH)){
                    return;
                }
                String serverData = new String(data.getData());
                ServerMeta serverMeta = JsonUtil.fromJson(serverData, ServerMeta.class);
                switch (type) {
                    case NODE_CREATED:
                        entities.put(serverMeta.getServerId(), serverMeta);
                        break;
                    case NODE_CHANGED:
                        entities.put(serverMeta.getServerId(), serverMeta);
                        break;
                    case NODE_DELETED:
                        entities.remove(serverMeta.getServerId());
                        break;
                    default:
                        break;
                }
            }
        },Executors.newSingleThreadExecutor());
         curatorCache.start();
    }

    @Override
    public Map<String, ServerMeta> getAllEntities() {
        return entities;
    }

    @Override
    public ServerMeta getEntity(String serverId) {
        return entities.get(serverId);
    }

    @Override
    public void stop() {
        curatorCache.close();
    }

    
}
