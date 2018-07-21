package com.longma.chatserver.test.testcodecexaple.codec;

import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * 在这里，编码解码其实是要互相对应的，只有相互知道对方的编码解码方式才能正确的读出消息。
 * @description: 解码器
 * @author viakiba
 * @date 2017年7月7日
 */
public class ChatMessageDecoder implements ProtocolDecoder{

	@Override
	public void decode(IoSession arg0, ByteBuffer in, ProtocolDecoderOutput out) throws Exception {
		try{
			while(in.hasRemaining()){//接收数据
				int length = in.getInt();//获取开头的长度标识(int 型，在endocer中通过in.getInt()设置的)  postion已经后移四个字节了
				byte[] temp = new byte[length];//根据长度标识实例化字节数组
				in.get(temp);//写入实体数据 到字节数组中
				String result = new String(temp);
				out.write(result);
				return ;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return ;
	}

	@Override
	public void dispose(IoSession arg0) throws Exception {
		System.out.println("ChatMessageDecoder dispose 执行清理中");
		
	}

	@Override
	public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1) throws Exception {
		System.out.println("结束解码");
		
	}
}
