package com.example.pointrpc.common.model;

import java.io.Serializable;

/**
 * RPC Response
 *
 * @author luxiaoxun
 */
public class RpcResponse implements MsgId,Serializable {
    private static final long serialVersionUID = 8215493329459772524L;
    public static final int reqId = 2;
    private String requestId;
    private String error;
    private Object result;

    @Override
    public int getMsgId() {
        return reqId;
    }

    public boolean isError() {
        return error != null;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
