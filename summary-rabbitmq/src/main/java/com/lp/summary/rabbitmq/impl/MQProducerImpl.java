package com.lp.summary.rabbitmq.impl;

import com.lp.summary.rabbitmq.MQProducer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/17.
 */
@Service("mqProducer")
public class MQProducerImpl implements MQProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;
    private static final Log log = LogFactory.getLog(MQProducerImpl.class);

    @Override
    public void sendDateToQueue(String queueKey, Object object) {
        try {
            amqpTemplate.convertAndSend(queueKey, object);
        } catch (Exception e) {
            log.error(e);
        }
    }
}
