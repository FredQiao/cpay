package com.cardpay.api.service;

import com.cardpay.rpc.service.HelloService;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/api")
public class HelloApi {

    @MotanReferer
    private HelloService helloService;

    @ApiOperation(value = "")
    @RequestMapping(value = "/hello/{word}", method = RequestMethod.GET)
    public String sayHello(@PathVariable String word){
        return helloService.hello(word);
    }

}
