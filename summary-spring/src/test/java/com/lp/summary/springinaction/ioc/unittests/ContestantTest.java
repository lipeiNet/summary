package com.lp.summary.springinaction.ioc.unittests;

import com.lp.summary.springinaction.aop.Contestant;
import com.lp.summary.springinaction.aop.Performer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/11/9.
 */
public class ContestantTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/aop/application-audience-config.xml");
        Object obj= context.getBean("performerImpl");
        Performer performer=(Performer)obj;
        performer.perform();
        Contestant contestant=(Contestant)context.getBean("performerImpl");
        contestant.receiveAward();
        for (Object o:obj.getClass().getDeclaredMethods()) {
            System.out.println(o.toString());
        }

    }
}
