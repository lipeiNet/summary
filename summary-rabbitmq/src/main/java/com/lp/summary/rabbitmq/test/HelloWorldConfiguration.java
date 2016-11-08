package com.lp.summary.rabbitmq.test;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2016/10/21.
 */
@Configuration
public class HelloWorldConfiguration {
    protected final String helloWorldQueueName = "hello.world.queue";
    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory=new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }
    @Bean
    public AmqpAdmin amqpAdmin(){
        return new RabbitAdmin(connectionFactory());
    }
    @Bean
    public Queue helloWorldQueue(){
        return new Queue(this.helloWorldQueueName);
    }
    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate template=new RabbitTemplate(connectionFactory());
        template.setRoutingKey(this.helloWorldQueueName);
        template.setQueue(this.helloWorldQueueName);
        return template;
    }
}
