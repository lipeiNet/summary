package com.lp.summary.rabbitmq;

/**
 * Created by Administrator on 2016/10/18.
 * rpc服务
 */
public interface RpcServer {

    /**
     * 发送信息
     * @param message
     * @return
     */
    String sendMessage(String message);
}
