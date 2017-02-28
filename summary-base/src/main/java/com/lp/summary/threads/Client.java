package com.lp.summary.threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/28.
 */
public class Client implements Runnable{
    private Handler handler;
    public Client(Handler handler){
        this.handler=handler;
    }

    public void run() {
        while (!Thread.interrupted()){
            System.out.println("客户端开始发送请求");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.handler.sendRequest();
            System.out.println("等待服务器响应");
            try {
                this.handler.waitResponse();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
