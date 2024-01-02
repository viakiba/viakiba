package com.example.pointrpc.common.serializer;

import java.util.Map;

public interface ISerializer {
    public abstract <T> byte[] serialize(T obj,String... param);

    public abstract <T> Object deserialize(int msgId,byte[] bytes);

    public abstract void msgIdToObj(Map<Integer,Class<?>> map);
}
