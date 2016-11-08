package com.lp.summary.springinaction.aop.impl;

import com.lp.summary.springinaction.aop.UserService;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/8.
 */
@Component
public class UserServiceImpl implements UserService {
    public void insert(String userName, int age) {
        System.out.println("用户名：" + userName + ";年龄:" + age);
    }

    public void insertUser(String userName) {
        System.out.println("用户名："+userName);
    }

    public void delete(Long userId) {
        System.out.println("用户id:" + userId);
    }

    public String select(Long userId) throws InterruptedException {
        Thread.sleep(100);
        System.out.println("用户名:" + userId.toString());
        return userId.toString();
    }

    public void throwEx() throws Exception {
        throw new Exception("抛出异常");
    }
}
