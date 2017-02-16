package com.lp.summary.sharding.mapper;

import com.lp.summary.sharding.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
public interface UserMapper {
    Integer insert(User u);

    List<User> findAll();

    List<User> findByUserIds(List<Integer> userIds);
}
