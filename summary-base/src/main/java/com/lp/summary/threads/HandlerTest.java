package com.lp.summary.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/28.
 */
public class HandlerTest {
    public static void main(String[] args) throws InterruptedException {
        Handler handler=new Handler();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new Client(handler));
        executorService.execute(new Server(handler));
        TimeUnit.SECONDS.sleep(20);
        executorService.shutdownNow();
    }
}
