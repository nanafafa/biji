package com.riji.service.impl;

import com.riji.dao.UserMapper;
import com.riji.pojo.User;
import com.riji.service.UserService;
import com.riji.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userMail, String userPassword) {
        User user = userMapper.login(userMail, MD5Util.encode(userPassword));
        return user;
    }
}
