package com.example.pointrpc.common.model;

public class ServerMeta {
    private String type;
    private String serverId;
    private String host;
    private String port;

    public ServerMeta(){

    }

    public ServerMeta(String type, String serverId, String host, String port) {
        this.type = type;
        this.serverId = serverId;
        this.host = host;
        this.port = port;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return port;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerId() {
        return serverId;
    }

    @Override
    public String toString() {
        return "ServerMeta [type=" + type + ", serverId=" + serverId + ", host=" + host + ", port=" + port + "]";
    }
 
}
