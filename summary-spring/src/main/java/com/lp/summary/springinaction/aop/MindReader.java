package com.lp.summary.springinaction.aop;

/**
 * Created by Administrator on 2016/11/7.
 * 读心者类
 */
public interface MindReader {
    /**
     *拦截志愿者的内心感应
     * @param thoughts 思想
     */
    void interceptThoughts(String thoughts);

    /**
     * 显示志愿者在想什么
     * @return
     */
    String getThoughts();
}
