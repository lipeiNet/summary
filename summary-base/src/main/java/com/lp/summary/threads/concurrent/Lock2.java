package com.lp.summary.threads.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lipei on 2017/3/10.
 */
public class Lock2 {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                String tName = Thread.currentThread().getName();
                while (!lock.tryLock()) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("等待获取锁");
                }
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(tName + ":" + i);
                    }
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                String tName = Thread.currentThread().getName();
                while (!lock.tryLock()) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("等待获取锁");
                }
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(tName + ":" + i);
                    }

                } catch (Exception e) {
                    System.out.println(tName + "出错了！！！");
                } finally {
                    System.out.println(tName + "释放锁！！");
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
