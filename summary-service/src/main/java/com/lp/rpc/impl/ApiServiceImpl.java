package com.lp.rpc.impl;


import com.lp.rpc.ApiService;
import com.lp.rpc.commen.ResponseBean;
import com.lp.summary.dao.UserDao;
import com.lp.web.beans.UserBean;
import com.migr.common.util.JsonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/6.
 */
public class ApiServiceImpl implements ApiService {
    private static final Log log = LogFactory.getLog(ApiServiceImpl.class);
    @Autowired
    private UserDao userDao;
    private String token;//供调用rpc校验使用

    public String getToken() {
        return token;
    }

    public ResponseBean add(String reqJson) {
        ResponseBean responseBean = new ResponseBean(ResponseBean.SUCCESS, "调用成功");
        try {
            Map map = JsonUtil.g.fromJson(reqJson, HashMap.class);
            String username = map.get("username").toString();
            String password = map.get("password").toString();
            String realname = map.get("realname").toString();
            Long userroleid =Double.valueOf(map.get("userroleid").toString()).longValue() ;
            UserBean userBean = new UserBean();
            userBean.setCreatedate(new Date());
            userBean.setPassword(password);
            userBean.setUserroleid(userroleid);
            userBean.setRealname(realname);
            userBean.setUsername(username);
            int count = userDao.add(userBean);
            responseBean.setReturnData(JsonUtil.g.toJson(count));
            responseBean.setReturnCode(10);
        } catch (Exception e) {
            log.error(e.getStackTrace());
            responseBean.setReturnCode(11);
            responseBean.setReturnMsg("服务器异常");
        }
        return responseBean;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
