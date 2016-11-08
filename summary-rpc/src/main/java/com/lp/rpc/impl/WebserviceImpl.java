package com.lp.rpc.impl;

import com.lp.rpc.WebService;
import com.lp.rpc.beans.UserBean;
import com.lp.rpc.commen.ResponseBean;
import com.migr.common.util.HttpClientUtil;
import com.migr.common.util.JsonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/7.
 */
public class WebserviceImpl implements WebService {
    private final static Log log = LogFactory.getLog(WebserviceImpl.class);
    private String url;
    private String token;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public ResponseBean add(UserBean userBean) {
        Map<String, String> map = new HashMap();
        ResponseBean rb = null;
        map.put("token", token);
        map.put("reqJson", JsonUtil.g.toJson(userBean));
        String reqUrl = url + "?m=add";
        log.debug(reqUrl);
        try {
            String str = HttpClientUtil.executeHttpRequestUTF(reqUrl, map);
            log.debug("add return data:" + str);
            rb = JsonUtil.g.fromJson(str, ResponseBean.class);
            log.debug("getPromInfo return Regions data" + reqUrl);
            return rb;
        } catch (Exception e) {
            rb = new ResponseBean();
            rb.setReturnObject(e);
            log.debug(e.getStackTrace());
            return rb;
        }
    }
}
