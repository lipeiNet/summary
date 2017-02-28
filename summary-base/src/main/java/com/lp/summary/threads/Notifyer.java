package com.lp.summary.threads;

/**
 * Created by Administrator on 2017/2/27.
 */
public class Notifyer implements Runnable{
    private Temp temp;
    public Notifyer(Temp temp){
        this.temp=temp;
    }
    public void run() {
        try {
            temp.notifyer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
