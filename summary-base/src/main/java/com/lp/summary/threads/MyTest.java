package com.lp.summary.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/27.
 */
public class MyTest {
    public static void main(String[] args) {
        Temp temp=new Temp();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new Waiter(temp));
        executorService.execute(new Notifyer(temp));
        executorService.shutdown();
    }
}
