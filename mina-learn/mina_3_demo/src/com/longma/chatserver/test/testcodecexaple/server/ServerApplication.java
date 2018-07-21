package com.longma.chatserver.test.testcodecexaple.server;

import java.net.InetSocketAddress;

import org.apache.mina.common.IoAcceptor;
import org.apache.mina.filter.LoggingFilter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.SocketAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptorConfig;

import com.longma.chatserver.test.testcodecexaple.codec.ChatCodecFactory;

/**
 * 此处解释 参考readme中的mina_1_demo
 * @description: 
 * @author viakiba
 * @date 2017年7月7日
 */
public class ServerApplication {
	
	private static final int SERVER_PORT = 8080;    
    
    public static void main( String[] args ) throws Throwable    
    {    
        IoAcceptor acceptor = new SocketAcceptor();    
            
        SocketAcceptorConfig cfg = new SocketAcceptorConfig();    
        cfg.setReuseAddress( true );    
        //此处注释查看 ClientApplication 中的注释即可
        cfg.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new ChatCodecFactory() ) );    
        cfg.getFilterChain().addLast( "logger", new LoggingFilter() );    
   
        acceptor.bind( new InetSocketAddress( "127.0.0.1",SERVER_PORT ),    
                new ServerHandler( ), cfg );    
        System.out.println( "The server Listening on port " + SERVER_PORT );    
    }    
}
