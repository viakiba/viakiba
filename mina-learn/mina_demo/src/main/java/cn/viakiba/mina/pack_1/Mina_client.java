package cn.viakiba.mina.pack_1;

import java.net.InetSocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.logging.MdcInjectionFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * Tcp
 * @author Administrator
 *
 */
public class Mina_client {
	private static final String HOSTNAME = "127.0.0.1";
	private static final int PORT = 9898;
	
	public static void main(String[] args) {
		System.out.println("tcp client");
		
		//客户端使用 NioSocketConnector类  此处和服务器的不同
		NioSocketConnector connector = new NioSocketConnector();
		
		//设置 过滤器
		connector.getFilterChain().addLast("logging", new LoggingFilter());
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(
				new ObjectSerializationCodecFactory()
				));
		connector.getFilterChain().addLast("mdc", new MdcInjectionFilter());
		
		//设置处理器
		connector.setHandler(new Mina_client_handler());
		
		IoSession session ;
		
		//创建一个会话并开始交互
		for(;;){
			ConnectFuture future = connector.connect(new InetSocketAddress(HOSTNAME, PORT));
            ConnectFuture awaitUninterruptibly = future.awaitUninterruptibly();
            session = awaitUninterruptibly.getSession();
            break;
		}
		
		session.getCloseFuture().awaitUninterruptibly();
		connector.dispose();
	}
}
