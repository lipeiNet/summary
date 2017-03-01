package com.lp.summary.threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/28.
 */
public class Client implements Runnable {
    private Handler handler;

    public Client(Handler handler) {
        this.handler = handler;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("客户端发送请求");
                TimeUnit.SECONDS.sleep(1);
                this.handler.sendRequest();//第二步
                System.out.println("等待服务端的响应");
                this.handler.waitResponse();//第三步
            }
        } catch (InterruptedException e) {

        }
        System.out.println("客户端已经完成请求");
    }
}
