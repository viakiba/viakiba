package com.longma.chatserver.test.testcodecexaple.codec;

import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * 此处实现的ProtocolCodecFactory接口用于注入到编解码中的ProtocolCodecFilter中
 * 具体查看readme
 * @description: 
 * @author viakiba
 * @date 2017年7月7日
 */
public class ChatCodecFactory implements ProtocolCodecFactory{
	
	private ProtocolEncoder chatMessageEncoder;
	private ProtocolDecoder chatMessageDecoder;
	
	/**
	 * 创建时，自动初始化上述变量
	 */
	public ChatCodecFactory() {
		this.chatMessageEncoder = new ChatMessageEncoder();
		this.chatMessageDecoder = new ChatMessageDecoder();
	}

	/**
	 * 返回编码方式对应的对象 class ChatMessageEncoder implements ProtocolEncoder
	 * 
	 * 当session向对方相应数据时，数据会进入chatMessageEncoder对象中的encode()方法中，编码成二进制数据通过out写出，到达下一级过滤器或者对应的accepotor/connector发送给对方
	 */
	@Override
	public ProtocolEncoder getEncoder() throws Exception {
		return chatMessageEncoder;
	}

	/**
	 * 返回解码方式对应的对象 class ChatMessageDecoder extends CumulativeProtocolDecoder
	 * 
	 * 当session接收到对方发来的数据时，会先进入ChatMessageDecoder的doDecode()方法，吧二进制数据转成对应的对象并通过out写出的下一级过滤器或者IoHandler中
	 */
	@Override
	public ProtocolDecoder getDecoder() throws Exception {
		return chatMessageDecoder;
	}
	
}
