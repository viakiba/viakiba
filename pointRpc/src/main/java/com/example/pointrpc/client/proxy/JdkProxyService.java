package com.example.pointrpc.client.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.example.pointrpc.client.connect.RpcClient;
import com.example.pointrpc.common.model.RpcRequest;

public class JdkProxyService implements IProxyService,InvocationHandler {

    private int serverId ;

    public JdkProxyService(int serverId){
        this.serverId = serverId;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] param) throws Throwable {
        Class<?> clazz = method.getDeclaringClass();
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(clazz.getName());
        rpcRequest.setMethodName(methodName);
        rpcRequest.setParameterTypes(parameterTypes);
        rpcRequest.setParameters(param);
        rpcRequest.setRequestId("11");
        Object sendMessageSync = RpcClient.getInstance().sendMessageSync(serverId, rpcRequest);
        return sendMessageSync;
    }
    
}
