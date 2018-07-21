package com.longma.chatserver.test.testcodecexaple.client;

import java.net.InetSocketAddress;

import org.apache.mina.filter.LoggingFilter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.SocketConnector;
import org.apache.mina.transport.socket.nio.SocketConnectorConfig;

import com.longma.chatserver.test.testcodecexaple.codec.ChatCodecFactory;

/**
 * 此处解释 参考readme中的mina_1_demo
 * @description: 
 * @author viakiba
 * @date 2017年7月7日
 */
public class ClientApplication {
	private static final String HOSTNAME = "127.0.0.1";    
    private static final int PORT = 8080;    
    private static final int CONNECT_TIMEOUT = 30; // seconds    
   
   
    public static void main( String[] args ) throws Throwable    
    {    
        SocketConnector connector = new SocketConnector();            
          
        SocketConnectorConfig cfg = new SocketConnectorConfig();    
        cfg.setConnectTimeout( CONNECT_TIMEOUT );   
        //这个地的使用的自定的 编码 译码  ChatCodecFactory实现了接口ProtocolCodecFactory 就可以自定义编解码
        //编码的自定义在ChatCodecFactory中的getEncoder（）进行实现 ProtocolEncoder接口的类  ChatMessageDecoder
        //解码的自定义在ChatCodecFactory中的getDecoder（）进行实现 ProtocolDecoder接口的类  ChatMessageEncoder
        //即可
        cfg.getFilterChain().addLast("codec", new ProtocolCodecFilter( new ChatCodecFactory() ) );    
        cfg.getFilterChain().addLast("logger", new LoggingFilter() );    
            
        connector.connect(new InetSocketAddress( HOSTNAME, PORT ),    
                        new ClientIoHandler(), cfg );    
    }   
}
