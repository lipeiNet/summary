package com.lp.summary.springinaction.ioc.unittests;

import com.lp.summary.springinaction.ioc.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Administrator on 2016/11/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/ioc/application-componenttest.xml")
public class CompactDiscTest {
    @Autowired
    private CompactDisc sgtPeppers;
    @Test
    public void cdNotShouldBeNull(){
        assertNotNull(sgtPeppers);
    }
}
