package com.example.pointrpc.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.pointrpc.common.invoke.MethodInvoke;
import com.example.pointrpc.common.model.MsgObjWrapper;
import com.example.pointrpc.common.model.PingRequest;
import com.example.pointrpc.common.model.RpcRequest;
import com.example.pointrpc.common.model.RpcResponse;
import com.example.pointrpc.server.service.ServiceManager;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class RpcServerHandler  extends SimpleChannelInboundHandler<MsgObjWrapper> {
    private static final Logger logger = LoggerFactory.getLogger(RpcServerHandler.class);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgObjWrapper msg) throws Exception {
        if (PingRequest.reqId == msg.getMsgId()) {
            logger.info("Server read heartbeat ping");
            return;
        }
        RpcRequest msgObj = (RpcRequest) msg.msgObj;

        logger.info("Receive request " + msgObj.getRequestId());
        RpcResponse rpcResponse = new RpcResponse();
        rpcResponse.setRequestId(msgObj.getRequestId());
        try{
            Object service = ServiceManager.getService(msgObj.getClassName());
            Object invoke = MethodInvoke.invoke(msgObj.getMethodName(), msgObj.getParameterTypes(), service, msgObj.getParameters());
            rpcResponse.setResult(invoke);
        }catch(Exception e){
            rpcResponse.setError(e.getMessage());
        }
        ctx.writeAndFlush(rpcResponse).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                logger.info("send resp {}" , rpcResponse.getRequestId());     
            }
        });
    }
    
}
