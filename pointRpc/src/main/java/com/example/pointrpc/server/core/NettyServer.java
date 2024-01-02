package com.example.pointrpc.server.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.pointrpc.common.register.IRegister;
import com.example.pointrpc.server.initializer.RpcInitializer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer implements IServer{

    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    private EventLoopGroup bossGroup = null;
    private EventLoopGroup workerGroup = null;
    private IRegister register = null;

    @Override
    public void start(IRegister register,String regServerType,String serverId,String regHost,String regPort) throws Exception {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new RpcInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture future = bootstrap.bind("0.0.0.0", Integer.parseInt(regPort)).sync();

            if (register != null) {
                register.registerServer(regServerType,serverId,regHost, regPort);
            }
            logger.info("Server started on port {}", regPort);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                logger.info("Rpc server remoting server stop");
            } else {
                logger.error("Rpc server remoting server error", e);
            }
        } finally {
            try {
                register.unRegisterServer();
                workerGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
            }
        }
    }

    @Override
    public void stop() throws Exception {
        logger.info("end ===========================");
        try {
                register.unRegisterServer();
                workerGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }
    
}
