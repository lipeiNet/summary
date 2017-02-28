package com.lp.summary.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/26.
 */
public class PeopleTests {
    public static void main(String[] args) throws InterruptedException {
        People people=new People();
        ExecutorService exec= Executors.newCachedThreadPool();
        exec.execute(new Dinner(people));
        exec.execute(new Wash(people));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
