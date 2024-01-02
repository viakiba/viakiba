package com.example.pointrpc.client.feature;

public abstract class CallBackRunnable<T> implements Runnable{

    private T res;
    
    @Override
    public void run() {
        start(res);
    }


    public void setRes(T res) {
        this.res = res;
    }

    public T getRes() {
        return res;
    }

    abstract void start(T o);
    
}
