package com.cardpay.api.service;

import com.cardpay.entity.User;
import com.cardpay.rpc.service.UserService;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/api/user")
public class UserApi {

    @MotanReferer
    private UserService userService;

    @ApiOperation(value = "")
    @RequestMapping(value = "/name/{word}", method = RequestMethod.GET)
    public User getByName(@PathVariable String name){
        return userService.findUserByName(name);
    }

}
