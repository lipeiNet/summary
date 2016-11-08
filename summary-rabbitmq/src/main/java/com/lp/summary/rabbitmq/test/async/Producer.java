package com.lp.summary.rabbitmq.test.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2016/10/21.
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        new AnnotationConfigApplicationContext(ProducerConfiguration.class);
    }
}
