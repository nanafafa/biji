package com.riji.dianzan;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 杨鹏发
 * @date 2020/2/3 0003
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    UserInfo findUserInfoById(String id);
}
