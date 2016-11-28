package com.lp.summary.rabbitmq.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016/11/18.
 */
public class SpittleAlertHandler implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            String body=new String(message.getBody(),"UTF-8");
            System.out.println(body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
