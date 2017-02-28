package com.lp.summary.threads.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/2/23.
 */
public class Counter {
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    private volatile Integer i = 0;
    public static void main(String[] args) throws InterruptedException {
        final  Counter cas=new Counter();
        List<Thread> ts=new ArrayList<Thread>(600);
        long start = System.currentTimeMillis();
        for (int j=0;j<10000;j++){
            Thread t=new Thread(new Runnable() {
                public void run() {
                    cas.count();
                    cas.softCount();
                }
            });
            ts.add(t);
        }
        for (Thread t:ts){
            t.start();
        }
        for (Thread t:ts){
            t.join();
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        System.out.println(System.currentTimeMillis() - start);
    }
    private void softCount(){
        for(;;){
            int i=atomicInteger.get();
            boolean suc=atomicInteger.compareAndSet(i,++i);
            if (suc){
                break;
            }
        }
    }
    private void count() {
        i++;
    }
}
