package com.lp.summary.springinaction.ioc.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Administrator on 2016/11/10.
 * BeanPostProcessor接口包括2个方法postProcessAfterInitialization
 * 和postProcessBeforeInitialization，这两个方法的第一个参数都是要处理的Bean对象
 * ，第二个参数都是Bean的name。返回值也都是要处理的Bean对象
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor(){
        super();
        System.out.println("这是BeanPostProcessor");
    }
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改");
        return s;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return s;
    }
}
