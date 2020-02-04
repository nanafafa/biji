package com.riji.service.impl;

import com.riji.dao.UserMapper;
import com.riji.dao.UserMapperPlus;
import com.riji.pojo.User;
import com.riji.service.UserService;
import com.riji.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl1 implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperPlus userMapperPlus;

    @Override
    public User login(String userMail, String userPassword) {
        User user = userMapper.login(userMail, MD5Util.encode(userPassword));
        return user;
    }

    @Override
    public User insert(String userMail, String userPassword) {
        User user = new User();
        user.setId("9");
        user.setUser_mail(userMail);
        user.setUser_password(userPassword);
        Integer count = userMapperPlus.insert(user);

        if(count>0){
            return user;
        }
        return null;
    }
}
