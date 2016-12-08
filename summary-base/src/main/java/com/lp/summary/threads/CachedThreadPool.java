package com.lp.summary.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/11/21.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<3;i++){
            executorService.execute(new SimpleRunnable());
        }
        executorService.shutdown();
        new Thread(){}.start();
    }
}
