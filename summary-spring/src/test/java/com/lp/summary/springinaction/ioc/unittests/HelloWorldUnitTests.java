package com.lp.summary.springinaction.ioc.unittests;

import com.lp.summary.springinaction.aop.Thinker;
import com.lp.summary.springinaction.ioc.HelloSpring;
import com.lp.summary.springinaction.ioc.Injection;
import com.lp.summary.springinaction.ioc.impl.HelloSpringImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.ObjectError;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Administrator on 2016/11/1.
 */
public class HelloWorldUnitTests {
    @Test
    public void HelloSpringTest(){
        //对于void的方法就要验证被调用的次数
        Injection mockInjection= mock(Injection.class);
        HelloSpring helloSpring=new HelloSpringImpl(mockInjection);
        helloSpring.sayHello("java");
        //验证print方法只被调用一次
        verify(mockInjection,times(1)).print("java");
    }

    @Test
    public void mytest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("/aop/application-audience-config.xml");
        //Thinker thinker=(Thinker)context.getBean("thinker");
         Object a=(Thinker) context.getBean("volunteer");
    }
}
