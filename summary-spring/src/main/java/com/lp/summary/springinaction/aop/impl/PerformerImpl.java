package com.lp.summary.springinaction.aop.impl;

import com.lp.summary.springinaction.aop.Performer;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/7.
 */
@Component
public class PerformerImpl implements Performer{
    public void perform() {
        System.out.println("演员正式表演");
    }
}
