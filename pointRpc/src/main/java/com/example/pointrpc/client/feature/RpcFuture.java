package com.example.pointrpc.client.feature;

import java.util.concurrent.CountDownLatch;
import com.example.pointrpc.common.model.RpcRequest;
import com.example.pointrpc.common.model.RpcResponse;

public class RpcFuture {
    private String requestId;
    private RpcRequest rpcRequest;
    private CountDownLatch cd;
    private RpcResponse rpcResponse;
    private CallBackRunnable<?> runnable;
    public RpcFuture(String requestId, RpcRequest rpcRequest, CountDownLatch cd) {
        this.requestId = requestId;
        this.rpcRequest = rpcRequest;
        this.cd = cd;
    }

    public RpcFuture(String requestId, RpcRequest rpcRequest, CallBackRunnable<?> runnable) {
        this.requestId = requestId;
        this.rpcRequest = rpcRequest;
        this.runnable = runnable;
    }

    public CallBackRunnable<?> getRunnable() {
        return runnable;
    }

    private boolean sync = true;

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    public boolean isSync() {
        return sync;
    }

    public RpcResponse getRpcResponse() {
        return rpcResponse;
    }

    public void setRpcResponse(RpcResponse rpcResponse) {
        this.rpcResponse = rpcResponse;
    }

    public CountDownLatch getCd() {
        return cd;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRpcRequest(RpcRequest rpcRequest) {
        this.rpcRequest = rpcRequest;
    }

    public RpcRequest getRpcRequest() {
        return rpcRequest;
    }
}
