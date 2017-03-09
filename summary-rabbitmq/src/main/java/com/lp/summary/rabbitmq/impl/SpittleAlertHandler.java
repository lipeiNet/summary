package com.lp.summary.rabbitmq.impl;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.JsonMessageConverter;

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
