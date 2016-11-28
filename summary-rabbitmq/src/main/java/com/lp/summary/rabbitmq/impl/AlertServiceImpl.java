package com.lp.summary.rabbitmq.impl;

import com.lp.summary.rabbitmq.AlertService;
import com.lp.summary.rabbitmq.domain.Spittle;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/11/18.
 */
public class AlertServiceImpl implements AlertService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendSpittleAlert(Spittle spittle) {
        rabbitTemplate.convertAndSend("spittle.alert.exchange",
                "spittle.alerts", spittle);
    }
}
