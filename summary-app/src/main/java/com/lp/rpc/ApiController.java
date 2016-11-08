package com.lp.rpc;

import com.lp.rpc.commen.ResponseBean;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/9/6.
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController {
    private static final Log log = LogFactory.getLog(ApiController.class);
    @Autowired
    private ApiService apiService;

    /**
     * 系统对外公开调用方法
     *
     * @param m       接口方法名
     * @param reqJson 请求参数
     * @param token   请求token
     * @return
     */
    @RequestMapping(value = "/exec", method = RequestMethod.POST)
    @ResponseBody
    public Object exec(@RequestParam(value = "m", required = true) String m,
                       @RequestParam(value = "reqJson", required = true) String reqJson,
                       @RequestParam(value = "token", required = true) String token) {
         log.info(String.format("m=%s,reqJson=%s,token=%s", m, reqJson, token));
        Class c = apiService.getClass();
        Method method = null;
        ResponseBean responseBean = null;
        if (!token.equals(apiService.getToken())) {
            log.error("token校验失败，token=" + token);
            responseBean = new ResponseBean(ResponseBean.FAILURE, "校验失败");
            return responseBean;
        }
        try {
            method = c.getMethod(m, String.class);
        } catch (Exception e) {
            log.error("m参数错误,m=" + m + ";req=" + reqJson, e);
            responseBean = new ResponseBean(ResponseBean.FAILURE, "m参数错误m=" + m);
            return responseBean;
        }
        if (StringUtils.isEmpty(reqJson)) {
            log.error("reqJson为空");
            responseBean = new ResponseBean(ResponseBean.FAILURE, "reqJson为空");
            return responseBean;
        }
        try {
            Object json = method.invoke(apiService, reqJson);
            return json;
        } catch (Exception e) {
            log.error("处理异常,m=" + m + ";req=" + reqJson, e);
            responseBean = new ResponseBean(ResponseBean.FAILURE, "服务器处理异常");
            return responseBean;
        }
    }
}
