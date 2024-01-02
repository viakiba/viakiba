package com.example.pointrpc.common.register;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;

import com.example.pointrpc.common.constant.Constant;
import com.example.pointrpc.common.model.ServerMeta;
import com.example.pointrpc.common.utils.JsonUtil;

public class ZKRegister implements IRegister{
  
    private ServerMeta serverMeta;
    private CuratorFramework zkClient;
    
    public ZKRegister(String registerAddr) {
        CuratorFramework zkClient = CuratorFrameworkFactory.newClient(registerAddr, 5000, 5000, new RetryOneTime(3000));
        zkClient.start();
        this.zkClient = zkClient;
    }

    @Override
    public void registerServer(String type, String serverId, String host, String port) throws Exception {
        ServerMeta serverMeta = new ServerMeta(type,serverId,host,port);
        String serverData = JsonUtil.toJson(serverMeta);
        zkClient.create().withMode(CreateMode.EPHEMERAL).forPath(Constant.DEFAULT_PATH+"/"+serverMeta.getServerId(),serverData.getBytes());
    }

    @Override
    public void unRegisterServer() throws Exception{
        zkClient.delete().forPath("/server/"+serverMeta.getServerId());
    }

}
