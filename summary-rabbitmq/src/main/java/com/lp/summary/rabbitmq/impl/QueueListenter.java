package com.lp.summary.rabbitmq.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/10/17.
 */
@Component
public class QueueListenter implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try{
            String body=new String(message.getBody(),"UTF-8");
            System.out.println(body);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
