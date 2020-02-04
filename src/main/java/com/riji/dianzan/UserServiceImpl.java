package com.riji.dianzan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 杨鹏发
 * @date 2020/2/3 0003
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserInfoRepository userRepository;
    @Override
    public UserInfo updateInfo(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userRepository.findUserInfoById(id);
    }
}
