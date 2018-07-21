package com.longma.chatserver.test.testserializable.client;

import java.net.InetSocketAddress;

import org.apache.mina.common.IoSession;
import org.apache.mina.filter.LoggingFilter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.SocketConnector;
import org.apache.mina.transport.socket.nio.SocketConnectorConfig;

import com.longma.chatserver.test.testserializable.entity.Message;
import com.longma.chatserver.test.testserializable.entity.UserInfo;

public class ClientApplication {
	private static final String HOSTNAME = "localhost";    
    private static final int PORT = 8080;    
    private static final int CONNECT_TIMEOUT = 30; // seconds    
   
   
    public static void main( String[] args ) throws Throwable    
    {    
    	
    	System.out.println("客户端connector启动。。。。");
        //实例化  客户端connector 对象
    	SocketConnector connector = new SocketConnector();   
        //实例化 connectConfig配置对象
        SocketConnectorConfig cfg = new SocketConnectorConfig();    
        //设置连接尝试等待时间
        cfg.setConnectTimeout( CONNECT_TIMEOUT );  
        //设置过滤器链 过滤传输/接收数据  使用序列化过滤器
        cfg.getFilterChain().addLast("codec", new ProtocolCodecFilter( new ObjectSerializationCodecFactory() ) );    
        cfg.getFilterChain().addLast("logger", new LoggingFilter() );    
        
        //略
        IoSession session;    
        Message msg = new Message(); 
        UserInfo userInfo = new UserInfo();
        userInfo.setUid("1");
        userInfo.setUsername("kitty");
        msg.setMsgBody("hello");
        msg.setUserInfo(userInfo);
        
        //连接服务端 并发送初始消息 msg
        connector.connect(new InetSocketAddress( HOSTNAME, PORT ),    
                        new ClientIoHandler(msg), cfg );    
    }   
}
