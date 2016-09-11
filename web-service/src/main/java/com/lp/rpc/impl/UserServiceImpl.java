package com.lp.rpc.impl;

import com.lp.rpc.UserService;
import com.lp.web.beans.UserBean;
import com.lp.rpc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/2.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public boolean add(UserBean userBean) {
        if (userDao.add(userBean)>=0){
            return true;
        }
        return false;
    }

    public boolean isExist(UserBean userBean) {
        if (userDao.isExistUser(userBean)>0){
            return true;
        }
        return false;
    }
}
