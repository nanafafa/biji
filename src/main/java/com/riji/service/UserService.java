package com.riji.service;

import com.riji.pojo.User;

import java.util.List;

public interface UserService {
    User login(String userMail,String userPassword);

    User insert(String userMail,String userPassword);

}
