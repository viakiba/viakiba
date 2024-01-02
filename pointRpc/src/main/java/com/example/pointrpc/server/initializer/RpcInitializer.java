package com.example.pointrpc.server.initializer;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.example.pointrpc.common.codec.Decoder;
import com.example.pointrpc.common.codec.Encoder;
import com.example.pointrpc.common.model.PingRequest;
import com.example.pointrpc.common.model.RpcRequest;
import com.example.pointrpc.common.model.RpcResponse;
import com.example.pointrpc.common.serializer.JsonSerializer;
import com.example.pointrpc.server.handler.RpcServerHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;

public class RpcInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        JsonSerializer jsonSerializer = new JsonSerializer();
        Map<Integer, Class<?>> map = new HashMap<>();
        map.put(RpcResponse.reqId, RpcResponse.class);
        map.put(RpcRequest.reqId, RpcRequest.class);
        map.put(PingRequest.reqId, PingRequest.class);
        jsonSerializer.msgIdToObj(map);

        ChannelPipeline cp = ch.pipeline();
        cp.addLast(new IdleStateHandler(0, 0, 10, TimeUnit.SECONDS));
        cp.addLast(new LengthFieldBasedFrameDecoder(65536, 0, 4, 0, 0));
        cp.addLast(new Decoder(jsonSerializer));
        cp.addLast(new Encoder(jsonSerializer));
        cp.addLast(new RpcServerHandler());
    }
    
}
