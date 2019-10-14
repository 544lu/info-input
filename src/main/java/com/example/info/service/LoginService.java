package com.example.info.service;

import com.example.info.domain.User;

/**
 * Created by llc on 2019/9/8.
 */
public interface LoginService {
    //用户登录
    boolean selectByNameAndPassword(User user);
}
