package com.lp.summary.threads;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2016/11/21.
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newCachedThreadPool();
        ArrayList<Future<String>> results=new ArrayList<Future<String>>();
        for (int i=0;i<5;i++){
            results.add(executor.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs:results) {
            if (fs.isDone()) {
                System.out.println(fs.get());
            }
        }
        executor.shutdown();
    }
}
