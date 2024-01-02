package com.example.pointrpc.common.codec;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.pointrpc.common.model.MsgObjWrapper;
import com.example.pointrpc.common.serializer.ISerializer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class Decoder extends ByteToMessageDecoder {
    private static final Logger logger = LoggerFactory.getLogger(Decoder.class);
    private ISerializer iSerializer ;

    public Decoder(ISerializer serializer) {
        this.iSerializer = serializer;
        logger.info("init decoder serializer"+serializer.getClass().getName());
    }

    @Override
    protected void decode(ChannelHandlerContext coxContext, ByteBuf byteBuf, List<Object> objects) throws Exception {
        if(byteBuf.readableBytes() < 4){
            return;
        }
        byteBuf.markReaderIndex();
        int dataLength = byteBuf.readInt();
        if(byteBuf.readableBytes() < dataLength){
            byteBuf.resetReaderIndex();
            return;
        }
        int msgId = byteBuf.readInt();
        byte[] data = new byte[dataLength-4];
        byteBuf.readBytes(data);
        Object o = iSerializer.deserialize(msgId,data);
        MsgObjWrapper msgObjWrapper = new MsgObjWrapper(msgId, o);
        objects.add(msgObjWrapper);
    }

}