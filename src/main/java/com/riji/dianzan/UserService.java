package com.riji.dianzan;

/**
 * @author 杨鹏发
 * @date 2020/2/3 0003
 */
public interface UserService {
    /**
     * 更新个人信息
     *
     * @param userInfo
     * @return
     */
    UserInfo updateInfo(UserInfo userInfo);

    UserInfo findById(String id);
}
