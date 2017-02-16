package com.lp.summary.sharding.service;

import com.lp.summary.sharding.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
public interface UserService {
    boolean insert(User u);

    List<User> findAll();

    List<User> findByUserIds(List<Integer> ids);

    void transactionTestSucess();

    void transactionTestFailure() throws IllegalAccessException;
}
