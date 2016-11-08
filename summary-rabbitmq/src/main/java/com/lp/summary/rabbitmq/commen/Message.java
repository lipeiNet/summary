package com.lp.summary.rabbitmq.commen;

import org.springframework.amqp.core.MessageProperties;

/**
 * Created by Administrator on 2016/10/21.
 * 消息类的定义
 */
public class Message {
    private final MessageProperties messageProperties;
    private final byte[] body;

    public Message(byte[] body, MessageProperties messageProperties) {
        this.body = body;
        this.messageProperties = messageProperties;
    }

    public MessageProperties getMessageProperties() {
        return this.messageProperties;
    }
}
