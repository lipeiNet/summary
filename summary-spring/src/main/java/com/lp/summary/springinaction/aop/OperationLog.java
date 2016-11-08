package com.lp.summary.springinaction.aop;

import org.aspectj.lang.JoinPoint;

/**
 * Created by Administrator on 2016/11/8.
 */
public interface OperationLog {
    /**
     * 操作日志记录
     */
    void logRecord(JoinPoint joinPoint);
    /**
     * 异常日志记录
     */
    void throwRecord(JoinPoint joinPoint,Exception e);
    /**
     * 查询日志
     */
    void selectRecord(JoinPoint joinPoint);
}
