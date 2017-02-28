package com.lp.summary.threads;

/**
 * Created by Administrator on 2017/2/28.
 */
public class Handler {
    private boolean isClientRequest=false;
    public void sendRequest(){
        synchronized (this){
            isClientRequest=true;
            this.notifyAll();
        }
    }
    public void waitResponse() throws InterruptedException {
        synchronized (this){
            while (isClientRequest){
                this.wait();
            }
        }
    }

    public void receiveRequest(){
        synchronized (this) {
            isClientRequest = false;
            this.notifyAll();
        }
    }
    public void waitRequest() throws InterruptedException {
        synchronized (this){
            while (!isClientRequest){
                this.wait();
            }
        }
    }
}
