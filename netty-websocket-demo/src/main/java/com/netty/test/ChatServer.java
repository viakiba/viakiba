package com.netty.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.util.concurrent.ImmediateEventExecutor;

import javax.net.ssl.SSLException;
import java.net.InetSocketAddress;
import java.security.cert.CertificateException;

public class ChatServer {
    private final ChannelGroup channelGroup = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);//通道组
    private final EventLoopGroup eventLoopGroup = new NioEventLoopGroup(1);//事件轮训接口
    private Channel channel;
    private int port;

    public ChatServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException, CertificateException, SSLException {
        final ChatServer chatServer = new ChatServer(9999);//指定监听端口
        ChannelFuture future = chatServer.start();//启动监听
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                chatServer.destroy();
            }
        });
//        future.channel().closeFuture().awaitUninterruptibly();
//        future.channel().closeFuture().syncUninterruptibly();
        System.out.println("============");
    }

    private ChannelFuture start() throws InterruptedException, SSLException, CertificateException {
        SelfSignedCertificate cert = new SelfSignedCertificate();
        SslContext context = SslContext.newServerContext(
                cert.certificate(), cert.privateKey());

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(eventLoopGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChatServerInitializer(channelGroup)) //添加处理的handler
//                .childHandler(new SecureChatServerInitializer(channelGroup,context)) //添加处理的handler
        ;
        ChannelFuture bind = serverBootstrap.bind(new InetSocketAddress(port));
        serverBootstrap.bind(new InetSocketAddress(9998));//此处bind可以绑定多个端口
        bind.syncUninterruptibly();//开始监听
        channel = bind.channel();
        return bind;
    }

    public void destroy(){
        if(channel != null){
            System.out.println("channel close");
            channel.close();
        }
        channelGroup.close();
        System.out.println("channelGroup close");
        eventLoopGroup.shutdownGracefully();
        System.out.println("eventLoopGroup close");
    }

}
