package com.lp.summary.dao;

import com.lp.web.beans.UserBean;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/2.
 */
@Repository
public interface UserDao {
    /**
     * 添加用户
     * @param userBean 用户信息
     * @return
     */
    int add(UserBean userBean);

    /**
     * 验证用户是否存在
     * @param userBean 用户信息
     * @return
     */
    int isExistUser(UserBean userBean);
}
