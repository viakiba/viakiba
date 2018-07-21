package com.longma.chatserver.client;

import java.net.InetSocketAddress;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.SocketConnector;
import org.apache.mina.transport.socket.nio.SocketConnectorConfig;

import com.longma.chatserver.codec.ChatCodecFactory;

/**
 * Client的启动入口
 * 
 * @author vk
 * 2017年7月4日
 */
public class ClientApplication {
	
	private final static int PORT = 8081;
	private final static String HOSTNAME = "127.0.0.1";
	
	public static void main(String[] args) {
		System.out.println("SocketConnector已经启动......");
		SocketConnectorConfig config = new SocketConnectorConfig();
		config.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ChatCodecFactory()));
		config.getSessionConfig().setReceiveBufferSize(40960);
		SocketConnector connector = new SocketConnector();
        connector.connect(new InetSocketAddress(HOSTNAME, PORT),new ClientIoHandler(),config);
	}
}
