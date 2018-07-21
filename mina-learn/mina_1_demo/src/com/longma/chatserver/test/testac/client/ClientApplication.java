package com.longma.chatserver.test.testac.client;

import java.net.InetSocketAddress;

import org.apache.mina.common.IoSession;
import org.apache.mina.filter.LoggingFilter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.SocketConnector;
import org.apache.mina.transport.socket.nio.SocketConnectorConfig;

import com.longma.chatserver.test.testac.entity.Message;

public class ClientApplication {
	private static final String HOSTNAME = "localhost";    
    private static final int PORT = 8080;    
    private static final int CONNECT_TIMEOUT = 30; // seconds    
   
   
    public static void main( String[] args ) throws Throwable    
    {    
    	//客户端创建connector对象用于连接服务端的acceptor
        SocketConnector connector = new SocketConnector();            
        // 实例化连接配置对象，一会装载于connector中
        SocketConnectorConfig cfg = new SocketConnectorConfig();    
        //设置连接超时等待时长
        cfg.setConnectTimeout( CONNECT_TIMEOUT );    
        //设置使用 mina 自带的序列化编解码类  对于传送的对象需要继承序列化接口
        cfg.getFilterChain().addLast("codec", new ProtocolCodecFilter( new ObjectSerializationCodecFactory() ) );    
        //设置log  可以略
        cfg.getFilterChain().addLast("logger", new LoggingFilter() );    
            
        IoSession session;    
        Message msg = new Message(); 
        msg.setMsgBody("hello");
        
        //连接服务器，并设置handler及connectorConfig
        connector.connect(new InetSocketAddress( HOSTNAME, PORT ),    
                        new ClientIoHandler(msg), cfg );    
    }   
}
