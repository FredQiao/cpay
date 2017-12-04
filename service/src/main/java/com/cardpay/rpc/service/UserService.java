package com.cardpay.rpc.service;

import com.cardpay.entity.User;

public interface UserService {
    User findUserByName(String name);
}
