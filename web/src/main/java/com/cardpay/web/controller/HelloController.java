package com.cardpay.web.controller;

import com.cardpay.rpc.service.HelloService;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api
@Controller
@RequestMapping("/web")
public class HelloController {

    @MotanReferer
    private HelloService helloService;

    @ApiOperation(value = "")
    @RequestMapping(value = "/hello/{word}", method = RequestMethod.GET)
    public String sayHello(@PathVariable String word, Model model) {
        model.addAttribute("name", word);
        return "hello";
    }
}
