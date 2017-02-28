package com.lp.summary.threads;

/**
 * Created by Administrator on 2017/2/27.
 */
public class Waiter implements Runnable{
    private Temp temp;
    public Waiter(Temp temp){
        this.temp=temp;
    }
    public void run() {
        try {
            temp.waiter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
