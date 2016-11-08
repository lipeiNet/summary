package com.lp.summary.rabbitmq;

import java.util.Map;

/**
 * Created by Administrator on 2016/10/21.
 */
public interface Exchange {
    String getName();
    String getExchangeType();
    boolean isDurable();
    boolean isAutoDelete();
    Map<String, Object> getArguments();
}
