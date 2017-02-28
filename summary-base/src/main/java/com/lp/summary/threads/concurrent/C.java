package com.lp.summary.threads.concurrent;

/**
 * Created by Administrator on 2017/2/27.
 */
public class C implements Runnable {
    private A a;
    public C(A a){
        this.a=a;
    }
    public void run() {
        a.a();
    }
}
