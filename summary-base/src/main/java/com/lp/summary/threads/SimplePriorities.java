package com.lp.summary.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/11/21.
 */
public class SimplePriorities implements Runnable {
    private int countDown=5;
    private volatile double d=5;
    private  int priortity;
    public SimplePriorities(int  priortity){
        this.priortity=priortity;
    }
    @Override
    public String toString(){
        return Thread.currentThread()+":"+countDown;
    }
    public void run() {
      Thread.currentThread().setPriority(priortity);
        while (true){
            for (int i=0;i<10000;i++){
                d+=(Math.PI+Math.E)/(double)i;
                if (i%1000==0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown==0){return;}
        }
    }

    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
