package com.lp.summary.springinaction.aop;

/**
 * Created by Administrator on 2016/11/8.
 */
public interface UserService {
    /**
     * 添加
     * @param userName
     * @param age
     */
    void insert(String userName,int age);

    /**
     * 插入用户
     */
    void insertUser(String userName);

    /**
     * 删除
     * @param userId
     */
    void delete(Long userId);

    /**
     * 查询
     * @param userId
     * @return
     */
    String select(Long userId) throws InterruptedException;

    /**
     * 抛出异常
     */
    void throwEx() throws Exception;
}
