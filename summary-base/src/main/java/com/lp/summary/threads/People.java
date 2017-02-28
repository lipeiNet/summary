package com.lp.summary.threads;

/**
 * Created by Administrator on 2017/2/26.
 */
public class People {
    private boolean isEat=false;
    public void dinnered(){
        synchronized (this){
            isEat=true;
            notifyAll();
        }
    }
    public void wash(){
        synchronized (this){
            isEat=false;
            notifyAll();
        }
    }
    public void waitDinner() throws InterruptedException {
        synchronized (this){
            while (!isEat){
                wait();
            }
        }
    }
    public void waitWash() throws InterruptedException {
        synchronized (this) {
            while (isEat) {
                wait();
            }
        }
    }
}
