package com.longma.chatserver.codec;

import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class ChatCodecFactory implements ProtocolCodecFactory{
	
	private ProtocolEncoder chatMessageEncoder;
	private ProtocolDecoder chatMessageDecoder;
	
	
	public ChatCodecFactory() {
		this.chatMessageEncoder = new ChatMessageEncoder();
		this.chatMessageDecoder = new ChatMessageDecoder();
	}

	
	@Override
	public ProtocolEncoder getEncoder() throws Exception {
		// TODO Auto-generated method stub
		return chatMessageEncoder;
	}

	@Override
	public ProtocolDecoder getDecoder() throws Exception {
		// TODO Auto-generated method stub
		return chatMessageDecoder;
	}
	
}
