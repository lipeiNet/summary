package com.lp.summary.threads.concurrent;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lipei on 2017/3/10.
 */
public class ReadWriteLockTest {
    private int value = 0;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void add(int value) {
        Lock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("添加开始时间：" + new Date());
            this.value += value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public void getValue() {
        Lock readLock = readWriteLock.readLock();
        readLock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("获取开始时间：" + new Date());
            System.out.println(value);
        } catch (InterruptedException e) {

        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
        Runnable task1 = new Runnable() {
            public void run() {
                readWriteLockTest.add(100);
            }
        };
        Runnable task2 = new Runnable() {
            public void run() {
                readWriteLockTest.getValue();
            }
        };
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i=0;i<2;i++){
            service.execute(task1);
        }
        for (int i=0;i<2;i++){
            service.execute(task2);
        }
        for (int i=0;i<2;i++){
            service.execute(task1);
        }
        service.shutdown();
    }
}
