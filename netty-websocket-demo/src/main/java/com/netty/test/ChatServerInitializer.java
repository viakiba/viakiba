package com.netty.test;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import sun.net.www.http.ChunkedInputStream;

public class ChatServerInitializer extends ChannelInitializer<Channel> {

    private final ChannelGroup group;

    public ChatServerInitializer(ChannelGroup group) {
        this.group = group;
    }

    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());//HttpServerCodec 将传入的字节转换为 HttpRequest，并将传出 的 HttpResponse 转换为字节
        pipeline.addLast(new ChunkedWriteHandler());//大文件响应到客户端
        pipeline.addLast(new HttpObjectAggregator(64 * 1024));//合并 Content
        pipeline.addLast(new HttpRequestHandler("/ws"));//处理http请求
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws")); // 升级websocket
        pipeline.addLast(new TextWebSocketFrameHandler(group));//socket的广播
    }

}
