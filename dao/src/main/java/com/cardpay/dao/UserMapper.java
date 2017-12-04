package com.cardpay.dao;

import com.cardpay.entity.User;

public interface UserMapper {
    User findByUserName(String username);
}
