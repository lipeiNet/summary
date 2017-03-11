package com.lp.summary.threads.concurrent;

/**
 * Created by lipei on 2017/3/10.
 */
public class Test1 implements Runnable{
    private Lock4 lock4;
    public Test1(Lock4 lock4){
        this.lock4=lock4;
    }
    public void run() {
        lock4.add("hello Lock");
    }
}
