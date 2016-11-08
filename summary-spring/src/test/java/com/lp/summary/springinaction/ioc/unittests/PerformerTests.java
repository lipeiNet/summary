package com.lp.summary.springinaction.ioc.unittests;

import com.lp.summary.springinaction.aop.Performer;
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
public class PerformerTests {
    @Autowired
    private Performer performer;
    @Autowired
    Performer performer2;
    @Test
    public void performTest(){
     performer.perform();
    }
    @Test
    public void performer2Test(){
        performer2.perform();
    }
}
