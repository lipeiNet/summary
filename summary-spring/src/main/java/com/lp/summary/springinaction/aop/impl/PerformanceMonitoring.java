package com.lp.summary.springinaction.aop.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/8.
 * 性能监控
 */
@Component
public class PerformanceMonitoring {
    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("执行对象：" + joinPoint.getTarget().getClass().getName());
        System.out.println("执行方法：" + joinPoint.getSignature().getName());
        if (!(null == joinPoint.getArgs() || joinPoint.getArgs().length <= 0)) {
            int i = 0;
            for (Object obj : joinPoint.getArgs()) {
                System.out.println("参数" + i + ":" + obj);
                i++;
            }
        }
        long start=System.currentTimeMillis();
        joinPoint.proceed();
        long end=System.currentTimeMillis();
        System.out.println("监听时间为："+(end-start)+"秒");
    }
}
