package com.longma.chatserver.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.SocketAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptorConfig;

import com.longma.chatserver.codec.ChatCodecFactory;

/**
 * Server的启动入口
 * 
 * @author vk
 * 2017年7月4日
 */
public class ServerApplication {
	
	private final static int PORT = 8081;
	private final static String HOSTNAME = "127.0.0.1";
	
	public static void main(String[] args) throws IOException {
		System.out.println("SocketAcceptor已经启动......");
		SocketAcceptorConfig cfg = new SocketAcceptorConfig();
		cfg.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ChatCodecFactory()));
		cfg.getSessionConfig().setReceiveBufferSize(40960);
		SocketAcceptor acceptor = new SocketAcceptor();
		acceptor.bind(new InetSocketAddress(HOSTNAME, PORT) , new ServerIoHandler(),cfg);
		}
	}
