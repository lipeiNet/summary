package com.lp.summary.threads.concurrent;

/**
 * Created by Administrator on 2017/2/27.
 */
public class B implements Runnable{
    private A a;
    public B(A a){
        this.a=a;
    }

    public void run() {
        a.b();
    }
}
