package com.longma.chatserver.codec;

import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class ChatMessageDecoder extends CumulativeProtocolDecoder{

	@Override
	protected boolean doDecode(IoSession session, ByteBuffer in, ProtocolDecoderOutput out) throws Exception {
		try{
			while(in.hasRemaining()){//接收数据
				int length = in.getInt();//获取开头的长度标识(int 型，在endocer中通过in.getInt()设置的)  postion已经后移四个字节了
				byte[] temp = new byte[length];//根据长度标识实例化字节数组
				in.get(temp);//写入实体数据 到字节数组中
				String result = new String(temp);
				System.out.println("doDecode"+result);
				out.write(result);
				return true;
			}
		}catch(Exception e){
			System.out.println("抛出解码异常");
			e.printStackTrace();
			throw new Exception(e);
		}
		return false;
	}
}
