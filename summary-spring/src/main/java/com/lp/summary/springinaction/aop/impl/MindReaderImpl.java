package com.lp.summary.springinaction.aop.impl;

import com.lp.summary.springinaction.aop.MindReader;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/7.
 */
@Component
public class MindReaderImpl implements MindReader {
    private String thoughts;
    public void interceptThoughts(String thoughts) {
        System.out.println("截取志愿者的心事");
        this.thoughts=thoughts;
    }

    public String getThoughts() {
        return this.thoughts;
    }
}
