package com.example.pointrpc.common.utils;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

public class JsonUtil {
    // private static Gson gson = new Gson();
    static Gson gson = new GsonBuilder().
                registerTypeAdapter(Class.class, new ClassCodec())
                .create();
    
    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return gson.fromJson(json, classOfT);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }
}

class ClassCodec implements JsonSerializer<Class<?>>, JsonDeserializer<Class<?>>{
    // 反序列化
    @Override
    public Class<?> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String clazz = jsonElement.getAsString();
        try {
            return Class.forName(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 序列化
    @Override
    public JsonElement serialize(Class<?> aClass, Type type, JsonSerializationContext jsonSerializationContext) {
        // 将 Class 变为 json
        return new JsonPrimitive(aClass.getName());
    }
}
