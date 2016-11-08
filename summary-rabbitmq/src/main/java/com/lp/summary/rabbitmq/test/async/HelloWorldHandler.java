package com.lp.summary.rabbitmq.test.async;

/**
 * Created by Administrator on 2016/10/21.
 */
public class HelloWorldHandler {
    public void handleMessage(String text) {
        System.out.println("Received: " + text);
    }
}
