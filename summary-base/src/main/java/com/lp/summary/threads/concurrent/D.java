package com.lp.summary.threads.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/27.
 */
public class D {
    public static void main(String[] args) {
        A a=new A();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new E((a)));
        executorService.execute(new B(a));
        executorService.execute(new C(a));
        executorService.shutdown();
    }
}
