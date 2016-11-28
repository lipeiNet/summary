package com.lp.summary.rabbitmq;

import com.lp.summary.rabbitmq.domain.Spittle;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface AlertService {
    /**
     * 发送信息
     * @param spittle
     */
    void sendSpittleAlert(Spittle spittle);
}

