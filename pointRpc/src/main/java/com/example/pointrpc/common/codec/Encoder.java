package com.example.pointrpc.common.codec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.pointrpc.common.model.MsgId;
import com.example.pointrpc.common.serializer.ISerializer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class Encoder extends MessageToByteEncoder<Object>{
    private static final Logger logger = LoggerFactory.getLogger(Encoder.class);
    private ISerializer iSerializer ;

    public Encoder(ISerializer serializer) {
        this.iSerializer = serializer;
        logger.info("init encoder serializer"+serializer.getClass().getName());
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        byte[] bytes = iSerializer.serialize(msg);
        out.writeInt(4+bytes.length);
        MsgId ms = (MsgId) msg;
        out.writeInt(ms.getMsgId());
        out.writeBytes(bytes);
    }
}
