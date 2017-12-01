package com.cardpay.rpc.service.impl;

import com.cardpay.rpc.service.HelloService;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;

@MotanService
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String world) {
        return "Hello " + world;
    }
}
