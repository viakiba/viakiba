package com.example.pointrpc.client.connect;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.example.pointrpc.client.feature.CallBackRunnable;
import com.example.pointrpc.client.feature.RpcFuture;
import com.example.pointrpc.client.handler.RpcClientHandler;
import com.example.pointrpc.client.proxy.JdkProxyService;
import com.example.pointrpc.common.codec.Decoder;
import com.example.pointrpc.common.codec.Encoder;
import com.example.pointrpc.common.constant.Constant;
import com.example.pointrpc.common.discovery.ZKDiscovery;
import com.example.pointrpc.common.model.PingRequest;
import com.example.pointrpc.common.model.RpcRequest;
import com.example.pointrpc.common.model.RpcResponse;
import com.example.pointrpc.common.model.ServerMeta;
import com.example.pointrpc.common.serializer.JsonSerializer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;

public class RpcClient {
    
    public static RpcClient rpcClient = new RpcClient();
    public static Map<Integer,ServerMeta> serverMetaMap = new ConcurrentHashMap<>();
    public static Map<Integer,RpcClientHandler> serverConnectHandlerMap = new ConcurrentHashMap<>(); 
    private ZKDiscovery zkDiscovery ;

    public static RpcClient getInstance(){
        return rpcClient;
    }

    public void init(){
        ZKDiscovery zkDiscovery = new ZKDiscovery();
        zkDiscovery.startDiscovery("127.0.0.1:2181", Constant.DEFAULT_PATH);
        ScheduledExecutorService newFixedThreadPool = Executors.newSingleThreadScheduledExecutor();
        newFixedThreadPool.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                Map<String,ServerMeta> allEntities = zkDiscovery.getAllEntities();
                for (ServerMeta serverMeta : allEntities.values()) {
                    if(serverMetaMap.containsKey(Integer.parseInt(serverMeta.getServerId()))){
                        continue;
                    }
                    serverMetaMap.put(Integer.parseInt(serverMeta.getServerId()), serverMeta);
                    connectServer(serverMeta);
                }
            }
        },0,100,TimeUnit.MILLISECONDS);
    }


    @SuppressWarnings("unchecked")
    public static <T> T getService(Class<T> clazz,int serverId){
        return (T)Proxy.newProxyInstance(
                        clazz.getClassLoader(), 
                        new Class[]{clazz}, 
                        new JdkProxyService(serverId)
                    );
    }

    public void connectServer(ServerMeta serverMeta){
        JsonSerializer jsonSerializer = new JsonSerializer();
        Map<Integer, Class<?>> map = new HashMap<>();
        map.put(RpcResponse.reqId, RpcResponse.class);
        map.put(RpcRequest.reqId, RpcRequest.class);
        map.put(PingRequest.reqId, PingRequest.class);
        jsonSerializer.msgIdToObj(map);

        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup group = new NioEventLoopGroup();

        RpcClientHandler rpcClientHandler = new RpcClientHandler( serverMeta, bootstrap);
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new IdleStateHandler(0, 0, 10, TimeUnit.SECONDS));
                        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65536, 0, 4, 0, 0));
                        ch.pipeline().addLast(new Decoder(jsonSerializer));
                        ch.pipeline().addLast(new Encoder(jsonSerializer));
                        ch.pipeline().addLast(rpcClientHandler);
                    }
                });
            
        // 连接到远程服务器
        bootstrap.connect(serverMeta.getHost(), Integer.parseInt(serverMeta.getPort()));
        serverConnectHandlerMap.put(Integer.parseInt(serverMeta.getServerId()), rpcClientHandler);
    }

    public Object sendMessageSync(Integer serverId,RpcRequest request) throws InterruptedException{
        RpcClientHandler rpcClientHandler = serverConnectHandlerMap.get(serverId);
        CountDownLatch cd = new CountDownLatch(1);
        RpcFuture sendMessageSync = rpcClientHandler.sendMessageSync(request,cd);
        cd.await(30,TimeUnit.SECONDS);
        RpcResponse rpcResponse = sendMessageSync.getRpcResponse();
        if(rpcResponse == null){
            return null;
        }
        Object result = sendMessageSync.getRpcResponse().getResult();
        return result;
    }

    public void sendMessageCallBack(Integer serverId,RpcRequest request,CallBackRunnable<?> runnable) throws InterruptedException{
        RpcClientHandler rpcClientHandler = serverConnectHandlerMap.get(serverId);
        rpcClientHandler.sendMessageCallBack(request, runnable);
    }

    public void stop(){
        zkDiscovery.stop();
    }
}
