package com.lp.summary.springinaction.ioc.impl;

import com.lp.summary.springinaction.ioc.HelloSpring;
import com.lp.summary.springinaction.ioc.Injection;

/**
 * Created by Administrator on 2016/11/1.
 */
public class HelloSpringImpl implements HelloSpring {

    private Injection injection;
    public HelloSpringImpl() {
    }

    private Long randomNumber;
    public HelloSpringImpl(Injection injection) {
        this.injection = injection;
    }

    public void sayHello(String name) {
        String result = injection.print(name);
        System.out.println("hello " + result);
    }

    public Long getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Long randomNumber) {
        this.randomNumber = randomNumber;
    }
}
