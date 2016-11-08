package com.lp.summary.springinaction.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Administrator on 2016/11/7.
 * 定义观众接口
 */
public interface Audience {
    /**
     * 表演之前（安排座位）
     */
    void takeSeats();

    /**
     * 表演之前（关掉所有的手机）
     */
    void turnoffCellphones();

    /**
     * 表演之后（鼓掌）
     */
    void applaud();

    /**
     * 表演失败以后（返回观众门票费）
     */
    void demandRefund();

    /**
     * 环绕通知
     */
    void watchPerformance(ProceedingJoinPoint proceedingJoinPoint);
}
