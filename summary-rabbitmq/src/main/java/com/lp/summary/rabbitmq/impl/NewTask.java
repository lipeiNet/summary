package com.lp.summary.rabbitmq.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/24.
 */
@Service
public class NewTask {
    @Autowired
    private static AmqpTemplate amqpTemplate;
    public void sendDateToQueue(String queueKey, Object object) {
        try {
            amqpTemplate.convertAndSend(queueKey, object);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
