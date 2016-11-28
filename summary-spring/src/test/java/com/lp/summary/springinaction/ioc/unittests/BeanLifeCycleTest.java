package com.lp.summary.springinaction.ioc.unittests;

import com.lp.summary.springinaction.ioc.impl.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/11/10.
 */
public class BeanLifeCycleTest {
    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");
        ApplicationContext factory = new ClassPathXmlApplicationContext("/ioc/application-beans.xml");
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Person person = (Person) factory.getBean("person");
        //MediaPlayer mediaPlayer= factory.getBean("mediaPlayer1",MediaPlayer.class);
        System.out.println(person);
        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
    }
}
