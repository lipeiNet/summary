package com.lp.summary.threads.concurrent;

/**
 * Created by lipei on 2017/3/10.
 */
public class Test2 implements Runnable{
    private Lock4 lock4;
    public Test2(Lock4 lock4){
        this.lock4=lock4;
    }
    public void run() {
        System.out.println(lock4.getValue()==null?"没有任何值":lock4.getValue());
    }
}
