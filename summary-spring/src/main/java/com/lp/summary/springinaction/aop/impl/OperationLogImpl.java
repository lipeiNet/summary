package com.lp.summary.springinaction.aop.impl;

import com.lp.summary.springinaction.aop.OperationLog;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/8.
 */
@Component
public class OperationLogImpl implements OperationLog {

    /**
     * 记录所有操作的日志
     */
    public void logRecord(JoinPoint joinPoint) {
        System.out.println("执行对象："+joinPoint.getTarget().getClass().getName());
        System.out.println("执行方法："+joinPoint.getSignature().getName());
        if (!(joinPoint.getArgs() == null) &&joinPoint.getArgs().length>0){
            int i=0;
            for (Object obj:joinPoint.getArgs()) {
                System.out.println("参数"+i+":"+obj);
                i++;
            }
        }
        System.out.println("操作日志");
    }

    /**
     * 记录所有异常的日志
     */
    public void throwRecord(JoinPoint joinPoint,Exception e) {
        System.out.println("执行对象：" + joinPoint.getTarget().getClass().getName());
        System.out.println("执行方法：" + joinPoint.getSignature().getName());
        if (!(null == joinPoint.getArgs()) && joinPoint.getArgs().length > 0) {
            int i = 0;
            for (Object obj : joinPoint.getArgs()) {
                System.out.println("参数" + i + ":" + obj);
                i++;
            }
        }
        System.out.println("异常日志:" + e.getStackTrace());
    }

    /**
     * 记录所有查询的日志
     */
    public void selectRecord(JoinPoint joinPoint) {
        System.out.println("执行对象："+joinPoint.getTarget().getClass().getName());
        System.out.println("执行方法："+joinPoint.getSignature().getName());
        if (null != joinPoint.getArgs() &&joinPoint.getArgs().length>0){
            int i=0;
            for (Object obj:joinPoint.getArgs()) {
                System.out.println("参数"+i+":"+obj);
                i++;
            }
        }
        System.out.println("查询日志");
    }
}
