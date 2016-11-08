package com.lp.summary.rabbitmq;

/**
 * Created by Administrator on 2016/10/17.
 */
public interface MQProducer {
    /**
     * 发送消息到指定队列
     * @param queueKey
     * @param object
     */
    void sendDateToQueue(String queueKey, Object object);
}
