package com.lp.summary.rabbitmq.impl;

import com.google.gson.reflect.TypeToken;
import com.lp.summary.rabbitmq.domain.Spittle;
import com.migr.common.util.JsonUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public class SpittleAlertHandler implements ChannelAwareMessageListener {
    private JsonMessageConverter jsonMessageConverter;

    public void setJsonMessageConverter(JsonMessageConverter jsonMessageConverter) {
        this.jsonMessageConverter = jsonMessageConverter;
    }

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            //channel.basicQos(1);
            long id=message.getMessageProperties().getDeliveryTag();
            if (id==2){
                throw new Exception("1");
            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            String data = jsonMessageConverter.fromMessage(message).toString();
            System.out.print(id);
        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),true,false);
            e.printStackTrace();
        }
    }
}
