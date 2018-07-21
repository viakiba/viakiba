package com.longma.chatserver.test.testserializable.server;

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
        IoAcceptor acceptor = new SocketAcceptor();    
            
        // Prepare the service configuration.    
        SocketAcceptorConfig cfg = new SocketAcceptorConfig();    
        cfg.setReuseAddress( true );    
   
        cfg.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new ObjectSerializationCodecFactory() ) );    
        cfg.getFilterChain().addLast( "logger", new LoggingFilter() );    
   
        acceptor.bind( new InetSocketAddress( "127.0.0.1",SERVER_PORT ),    
                new ServerHandler( ), cfg );    
        System.out.println( "The server Listening on port " + SERVER_PORT );    
    }    
}
