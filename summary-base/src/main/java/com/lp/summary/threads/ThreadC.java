package com.lp.summary.threads;

/**
 * Created by Administrator on 2017/2/27.
 */
public class ThreadC implements Runnable {
    private ThreadB threadB;
    public ThreadC(ThreadB threadB){
        this.threadB=threadB;
    }
    public void run() {
        synchronized (threadB){
            System.out.println(Thread.currentThread()+"开始等待");
            try {
                wait();
                System.out.println(threadB.total);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
