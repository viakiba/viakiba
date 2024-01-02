package com.example.pointrpc.common.model;

public class MsgObjWrapper {
    public int msgId;
    public Object msgObj;

    public MsgObjWrapper(int msgId, Object msgObj) {
        this.msgId = msgId;
        this.msgObj = msgObj;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public void setMsgObj(Object msgObj) {
        this.msgObj = msgObj;
    }

    public int getMsgId() {
        return msgId;
    }

    public Object getMsgObj() {
        return msgObj;
    }

    @Override
    public String toString() {
        return msgId +"  " + msgObj.toString();
    }
}
