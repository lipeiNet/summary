package com.lp.summary.others;

/**
 * Created by Administrator on 2017/2/19.
 */
public class App2Test {

    public static void main(String[] args) throws InterruptedException {
        concurrency();
    }
    private static void concurrency() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread thread=new Thread(new Runnable() {
            public void run() {
                int a=0;
                for (long i=0;i<100;i++){
                    a++;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        int b=0;
        for(int j=0;j<100;j++){
            b++;
        }

        thread.join();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}

