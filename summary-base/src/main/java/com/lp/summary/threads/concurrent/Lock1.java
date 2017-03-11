package com.lp.summary.threads.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lipei on 2017/3/10.
 */
public class Lock1 {
    static int value = 0;
    static Lock lock = new ReentrantLock();

    static class Task1 implements Runnable {
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "开始执行");
            lock.lock();
            try {
                for (int i = 0; i < 1000000; i++) {
                    value++;
                }
                System.out.println(value);
            } finally {
                lock.unlock();
            }
        }
    }
    static class Task2 implements Runnable {
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "开始执行");
            lock.lock();
            try {
                for (int i = 0; i < 1000000; i++) {
                    value++;
                }
                System.out.println(value);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        service.execute(new Task1());
        service.execute(new Task2());
        service.shutdown();
    }
}
