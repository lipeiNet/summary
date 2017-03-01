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
        try {
            while (!Thread.interrupted()) {
                System.out.println("等待客户端请求");
                this.handler.waitRequest();//第一步
                System.out.println("处理客户端请求");
                TimeUnit.SECONDS.sleep(1);
                this.handler.receiveRequest();//第四步
            }
        } catch (InterruptedException e) {

        }
        System.out.println("服务端处理已经完成");
    }
}