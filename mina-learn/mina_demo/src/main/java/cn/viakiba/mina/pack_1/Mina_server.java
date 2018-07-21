package cn.viakiba.mina.pack_1;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.logging.MdcInjectionFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class Mina_server {
	
	private static final int PORT = 9898;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Tcp Server");
		
		//服务器端 使用 NioSocketAcceptor （acceptor） 进行统一接收
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		
		//设置 过滤器 链
		acceptor.getFilterChain().addLast("logging", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
		acceptor.getFilterChain().addLast("mdc", new MdcInjectionFilter());
		
		//设置 处理器
		acceptor.setHandler(new Mina_server_handler());
		
		//设置 接收的 流的大小 以及空闲时间
		acceptor.getSessionConfig().setReadBufferSize(4098);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 20);
		
		//绑定监听端口
		acceptor.bind(new InetSocketAddress( PORT));
	}
}
