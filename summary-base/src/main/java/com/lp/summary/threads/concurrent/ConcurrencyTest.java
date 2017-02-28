package com.lp.summary.threads.concurrent;

/**
 * Created by Administrator on 2017/2/22.
 */
public class ConcurrencyTest {

    private static final long count=10000000000l;

    public static void main(String[] args) throws InterruptedException {
        concurrentcy();
        serial();
    }
    private static void concurrentcy() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread thread=new Thread(new Runnable() {
            public void run() {
                int a=0;
                for (long i=0;i<count;i++){
                    a++;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b++;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :" + time+"ms,b="+b);
    }
    private static void serial(){
        long start=System.currentTimeMillis();
        int a=0;
        for (long i=0;i<count;i++){
            a++;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b++;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time+"ms,b="+b);
    }
}
