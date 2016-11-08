package com.lp.summary.springinaction.aop.impl;

import com.lp.summary.springinaction.aop.Audience;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/7.
 */
@Component
public class AudienceImpl implements Audience {
    public void takeSeats() {
        System.out.println("表演之前，为观众安排座位");
    }

    public void turnoffCellphones() {
        System.out.println("表演之前，所有观众关闭掉手机");
    }

    public void applaud() {
        System.out.println("表演之后，观众鼓掌");
    }

    public void demandRefund() {
        System.out.println("表演失败之后，返回观众门票费");
    }

    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        System.out.println("表演之前，为观众安排座位");
        System.out.println("表演之前，所有观众关闭掉手机");
        long start=System.currentTimeMillis();
        try {
            joinPoint.proceed();
            Thread.sleep(100);
            long end=System.currentTimeMillis();
            System.out.println("表演之后，观众鼓掌");
            System.out.println("演员表演的时间："+(end-start)+"秒");
        } catch (Throwable throwable) {
            System.out.println("表演失败之后，返回观众门票费");
        }
    }
}
