package com.longma.chatserver.test.testac.Server;

import java.net.InetSocketAddress;

import org.apache.mina.common.IoAcceptor;
import org.apache.mina.filter.LoggingFilter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.SocketAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptorConfig;

public class ServerApplication {
	
	private static final int SERVER_PORT = 8080;    
    
    public static void main( String[] args ) throws Throwable    
    {    
    	System.out.println( "服务器监听端口： " + SERVER_PORT ); 
    	
    	//实例化 acceptor  服务器端
        IoAcceptor acceptor = new SocketAcceptor();    
            
        //创建 acceptor 配置对象    
        SocketAcceptorConfig cfg = new SocketAcceptorConfig();    
        cfg.setReuseAddress( true );    
        //设置过滤器链
        cfg.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new ObjectSerializationCodecFactory() ) );    
        cfg.getFilterChain().addLast( "logger", new LoggingFilter() );    
        //绑定端口
        acceptor.bind( new InetSocketAddress( "127.0.0.1",SERVER_PORT ),    
                new ServerHandler( ), cfg );    
           
    }    
}
