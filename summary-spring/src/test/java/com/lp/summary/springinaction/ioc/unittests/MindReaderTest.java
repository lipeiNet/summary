package com.lp.summary.springinaction.ioc.unittests;

import com.lp.summary.springinaction.aop.MindReader;
import com.lp.summary.springinaction.aop.Thinker;
import com.lp.summary.springinaction.aop.impl.MindReaderImpl;
import com.lp.summary.springinaction.aop.impl.Volunteer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/11/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/aop/application-audience-config.xml")
public class MindReaderTest {
    @Autowired
    private Thinker volunteer;
    @Autowired
    private MindReader mindReaderImpl;
    @Test
    public void thinkOfSomethingTest(){
        volunteer.thinkOfSomething("Hello Aop args");
        Assert.assertEquals("Hello Aop args",mindReaderImpl.getThoughts());
    }
}
