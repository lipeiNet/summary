package com.lp.rpc;

import com.lp.web.beans.UserBean;

/**
 * Created by Administrator on 2016/9/2.
 */
public interface UserService {
   /**
    * 添加用户信息
    * @param userBean
    * @return
     */
   boolean add(UserBean userBean);

   /**
    * 验证用户是否存在
    * @param userBean
    * @return
     */
   boolean isExist(UserBean userBean);
}
