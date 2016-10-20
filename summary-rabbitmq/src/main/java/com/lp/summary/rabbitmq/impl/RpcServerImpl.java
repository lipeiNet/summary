package com.lp.summary.rabbitmq.impl;

import com.lp.summary.rabbitmq.RpcServer;

/**
 * Created by Administrator on 2016/10/18.
 */
public class RpcServerImpl implements RpcServer {
    @Override
    public String sendMessage(String message) {
        return "hello" + message;
    }
}
