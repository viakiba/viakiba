package com.example.pointrpc.common.serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.DefaultInstantiatorStrategy;
import com.example.pointrpc.common.model.RpcRequest;
import com.example.pointrpc.common.model.RpcResponse;

public class JsonSerializer implements ISerializer{
    Map<Integer, Class<?>> map = new HashMap<>();

    @Override
    public <T> byte[] serialize(T obj, String... param) {
        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(false);
        kryo.setWarnUnregisteredClasses(true);
        kryo.setReferences(false);
        kryo.register(RpcRequest[].class);
        kryo.register(RpcResponse[].class); 
        kryo.register(RpcRequest.class);
        kryo.register(RpcResponse.class);
        // kryo.register(java.lang.Object[].class);
        

        ( (DefaultInstantiatorStrategy) kryo.getInstantiatorStrategy()).setFallbackInstantiatorStrategy((new DefaultInstantiatorStrategy()).getFallbackInstantiatorStrategy());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output out = new Output(byteArrayOutputStream);
        try {
            kryo.writeObject(out, obj);
            out.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Object deserialize(int msgId,byte[] bytes) {
        Class<?> clazz = map.get(msgId);
        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(false);
        kryo.setWarnUnregisteredClasses(true);
        kryo.setReferences(false);
        kryo.register(RpcRequest[].class);
        kryo.register(RpcResponse[].class); 
        kryo.register(RpcRequest.class);
        kryo.register(RpcResponse.class); 
        // kryo.register(java.lang.Object[].class);

        ( (DefaultInstantiatorStrategy) kryo.getInstantiatorStrategy()).setFallbackInstantiatorStrategy((new DefaultInstantiatorStrategy()).getFallbackInstantiatorStrategy());

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Input in = new Input(byteArrayInputStream);
        try {
            Object result = kryo.readObject(in, clazz);
            in.close();
            return result;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void msgIdToObj(Map<Integer, Class<?>> map) {
        this.map = map;
    }

    
}