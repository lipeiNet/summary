package com.lp.summary.springinaction.ioc.unittests;

import com.lp.summary.springinaction.aop.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Administrator on 2016/11/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/aop/application-user-aop.xml")
public class LogTest
{
    @Autowired
    private UserService userService;
    @Test
    public void insertTest(){
        userService.insert("1",1);
        userService.insertUser("lisi");
    }
    @Test
    public void deleteTest(){
        userService.delete(1L);
    }
    @Test
    public void selectTest() throws InterruptedException {
        userService.select(1L);
    }
    @Test
    @ExceptionHandler
    public void throwEx() throws Exception {
        userService.throwEx();
    }
}
