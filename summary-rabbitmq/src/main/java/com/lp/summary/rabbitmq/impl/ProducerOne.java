package com.lp.summary.rabbitmq.impl;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by Administrator on 2016/10/21.
 */
public class ProducerOne {

    /**
     * 使用纯java，命令发送和接收消息
     * @param args
     */
    public static void main(String[] args) {
        ConnectionFactory connectionFactory=new CachingConnectionFactory("localhost");
        AmqpAdmin amqpAdmin=new RabbitAdmin(connectionFactory);
        amqpAdmin.declareQueue(new Queue("myqueue"));
        AmqpTemplate amqpTemplate=new RabbitTemplate(connectionFactory);
        amqpTemplate.convertAndSend("myqueue","hello world");
        String result=(String) amqpTemplate.receiveAndConvert("myqueue");
        System.out.println(result);
    }
}
