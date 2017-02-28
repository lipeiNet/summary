package com.lp.summary.threads;

/**
 * Created by Administrator on 2017/2/26.
 */
public class ThreadB implements Runnable{
    int total;
    public void run()
    {
        synchronized (this)
        {
            System.out.println(Thread.currentThread()+"开始运行");
            for (int i = 0; i < 10; i++)
            {
                total += i;
            }
            notify();
        }
    }
}
