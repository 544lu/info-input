package com.example.info.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.info.domain.User;
import com.example.info.repository.UserRepository;
import com.example.info.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by llc on 2019/9/8.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public boolean selectByNameAndPassword(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", user.getUserName());
        wrapper.eq("password", user.getPassword());
        User ur = userRepo.selectOne(wrapper);
        if (ur == null) {
            return false;
        } else {
            return true;
        }
    }
}
