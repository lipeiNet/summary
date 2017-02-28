package com.lp.summary.threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/27.
 */
public class Temp {
    int count=0;
    public void waiter() throws InterruptedException {
        synchronized (this) {
               System.out.println("等待");
               wait();
               System.out.println(this.count);
        }
    }
    public void notifyer() throws InterruptedException {
        synchronized (this){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("唤醒");
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread()+"notifyer:"+i);
                count+=i;
            }
            notify();
        }
    }
}
