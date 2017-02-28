package com.lp.summary.threads.concurrent;

/**
 * Created by Administrator on 2017/2/27.
 */
public class A {
    private Object obj="123";
    public  void a(){
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + "a:" + i);
            }
        }
    }
    public void b(){
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + "b:" + i);
            }

    }
}
