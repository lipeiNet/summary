package com.lp.summary.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/26.
 */
public class ThreadA {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        /*System.out.println("b is start....");
        synchronized (b)// 释放锁（交出对锁的控制权）
        {
            try {
                System.out.println("Waiting for b to complete...");
                //b.wait();
                for (int j=0;j<10;j++){
                    System.out.println(j+"="+j);
                }
                System.out.println("Completed.Now back to main thread");
            } catch (Exception e) {
            }
        }
        System.out.println("Total is :" + b.total);*/
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(b);
        executorService.execute(new ThreadC(b));
        executorService.shutdown();
    }
}
