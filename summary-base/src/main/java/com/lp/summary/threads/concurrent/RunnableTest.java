package com.lp.summary.threads.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/23.
 */
public class RunnableTest implements Runnable {
    private Object str=new Object();
    private  void testSyncMethod() {
        synchronized (str) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getId() + "testSyncMethod:" + i);
            }
        }
    }
    private void testSyncBlock() {
        synchronized (RunnableTest.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getId()+"testSyncBlock:" + i);
            }
        }
    }
    private void testOne(){
        for (int i=0;i<10;i++) {
            System.out.println(Thread.currentThread().getId() + "testOne:"+i);
        }
    }
    public void run() {
    testSyncMethod();
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        RunnableTest rt = new RunnableTest();
        RunnableTest rt1 = new RunnableTest();
        exec.execute(rt);
        //rt.testOne();
        exec.execute(rt1);
        exec.shutdown();
    }
}
