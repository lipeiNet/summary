package com.lp.summary.rabbitmq.impl;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/10/24.
 */
@Component
public class Work2 implements ChannelAwareMessageListener{

    @Override
    public void onMessage(Message message, final Channel channel) throws Exception {
        channel.basicQos(1);
        System.out.println("Worker2  Waiting for messages");
        try{
            String body=new String(message.getBody(),"UTF-8");
            System.out.println(body);
        }finally {
            System.out.println("Worker2 Done");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
