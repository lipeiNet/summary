package com.lp.summary.rabbitmq.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ErrorHandler;

/**
 * Created by Administrator on 2016/12/12.
 * 异常处理，出现异常时记录异常信息
 */
public class MQErrorHandler implements ErrorHandler{
    @Autowired

    @Override
    public void handleError(Throwable throwable) {

    }
}
