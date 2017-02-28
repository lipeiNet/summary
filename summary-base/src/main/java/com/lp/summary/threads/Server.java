package com.lp.summary.threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/28.
 */
public class Server implements Runnable {
    public Handler handler;

    public Server(Handler handler) {
        this.handler = handler;
    }

    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("等待客户端请求");
            try {
                this.handler.waitRequest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("处理客户端请求");
            this.handler.receiveRequest();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}