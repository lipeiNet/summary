package com.lp.summary.dubbo.provider.impl;

import com.lp.summary.dubbo.provider.DemoService;

/**
 * Created by Administrator on 2016/10/27.
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
            return "Hello " + name;
    }
}
