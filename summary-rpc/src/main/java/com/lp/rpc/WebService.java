package com.lp.rpc;

import com.lp.rpc.beans.UserBean;
import com.lp.rpc.commen.ResponseBean;

/**
 * Created by Administrator on 2016/9/7.
 */
public interface WebService {
    ResponseBean add(UserBean userBean);
}
