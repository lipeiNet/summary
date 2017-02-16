package com.lp.summary.others;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/1/10.
 */
public class TaskJobTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("task_spring.xml");
    }
}
