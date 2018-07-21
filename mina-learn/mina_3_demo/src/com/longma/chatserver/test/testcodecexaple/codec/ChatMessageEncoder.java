package com.longma.chatserver.test.testcodecexaple.codec;

import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/**
 * 在这里，编码解码其实是要互相对应的，只有相互知道对方的编码解码方式才能正确的读出消息。
 * @description: 编码器
 * @author viakiba
 * @date 2017年7月7日
 */
public class ChatMessageEncoder implements ProtocolEncoder{

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		try{
			System.out.println("ChatMessageEncoder encode() 执行中.... ");
			String mess = (String) message;
			int bufflen = mess.getBytes().length;//长度标识 是 int 型 4字节
			ByteBuffer buffer = ByteBuffer.allocate(bufflen+4);//长度标识的长度与实际数据的长度
			buffer.putInt(bufflen);//放入长度标识  占开头的四个字节（int型）
			buffer.put(mess.getBytes());//放入实际数据
			buffer.flip();//修正postion至起始位
			out.write(buffer);//写出
			System.out.println("编码结束并发送到指定客户端");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ChatMessageEncoder dispose() 执行清理中.... ");
	}

}
