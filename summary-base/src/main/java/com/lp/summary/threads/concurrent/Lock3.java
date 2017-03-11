package com.lp.summary.threads.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lipei on 2017/3/10.
 */
public class Lock3 {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        final Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("等待被中断");
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println("我被中断了");
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {

                }
                thread1.interrupt();
                System.out.println("线程1已经被中断");
            }
        });
        thread1.start();
        thread2.start();
    }
}
