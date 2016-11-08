package com.lp.summary.springinaction.aop.impl;

import com.lp.summary.springinaction.aop.Thinker;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/7.
 */
@Component()
public class Volunteer implements Thinker {
    private String thoughts;
    public void thinkOfSomething(String thoughts) {
        this.thoughts=thoughts;
    }
}
