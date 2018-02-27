package com.cardpay.rpc.service.impl;

import com.cardpay.dao.UserRepository;
import com.cardpay.entity.User;
import com.cardpay.rpc.service.UserService;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import org.springframework.beans.factory.annotation.Autowired;

@MotanService
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByName(String name) {
        return userRepository.findByUsername(name);
    }
}
