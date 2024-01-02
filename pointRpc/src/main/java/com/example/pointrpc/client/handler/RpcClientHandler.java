package com.example.pointrpc.client.handler;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.pointrpc.client.feature.CallBackRunnable;
import com.example.pointrpc.client.feature.RpcFuture;
import com.example.pointrpc.common.model.MsgObjWrapper;
import com.example.pointrpc.common.model.RpcRequest;
import com.example.pointrpc.common.model.RpcResponse;
import com.example.pointrpc.common.model.ServerMeta;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RpcClientHandler  extends SimpleChannelInboundHandler<MsgObjWrapper>{
    private ChannelHandlerContext ctx ;
    private ConcurrentHashMap<String, RpcFuture> pendingRPC = new ConcurrentHashMap<>();
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    private ServerMeta serverMeta;
    private Bootstrap bootstrap;
    

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        this.ctx = ctx;
    }

    public RpcClientHandler(ServerMeta serverMeta,Bootstrap bootstrap) {
        this.serverMeta = serverMeta;
        this.bootstrap = bootstrap;
    }

    public void sendMessageCallBack(RpcRequest rpcRequest,CallBackRunnable<?> runnable) throws InterruptedException{
        RpcFuture rpcFuture = new RpcFuture(rpcRequest.getRequestId(),rpcRequest,runnable);
        rpcFuture.setSync(false);
        ctx.channel().writeAndFlush(rpcRequest).sync();
        System.out.println(serverMeta);
    }

    public RpcFuture sendMessageSync(RpcRequest rpcRequest,CountDownLatch cd) throws InterruptedException{
        RpcFuture rpcFuture = new RpcFuture(rpcRequest.getRequestId(),rpcRequest,cd);
        pendingRPC.put(rpcRequest.getRequestId(), rpcFuture);
        rpcFuture.setSync(true);
        ChannelFuture sync = ctx.channel().writeAndFlush(rpcRequest).sync();
        if(sync.isSuccess()){
            return rpcFuture;
        }
        return null;
    }

    

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg2) throws Exception {
        MsgObjWrapper msg1 = (MsgObjWrapper) msg2;
        RpcResponse msg = (RpcResponse) msg1.msgObj;
        RpcFuture rpcFuture = pendingRPC.get(msg.getRequestId());
        rpcFuture.setRpcResponse(msg);
        if(rpcFuture.isSync()){
            rpcFuture.getCd().countDown();
        }else{
            CallBackRunnable<?> runnable = rpcFuture.getRunnable();
            executorService.submit(runnable);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgObjWrapper msg1) throws Exception {
        RpcResponse msg = (RpcResponse) msg1.msgObj;
        RpcFuture rpcFuture = pendingRPC.get(msg.getRequestId());
        rpcFuture.setRpcResponse(msg);
        if(rpcFuture.isSync()){
            rpcFuture.getCd().countDown();
        }else{
            CallBackRunnable<?> runnable = rpcFuture.getRunnable();
            executorService.submit(runnable);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        bootstrap.connect().sync();
    }
    
}
