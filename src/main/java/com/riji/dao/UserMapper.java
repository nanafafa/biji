package com.riji.dao;

import com.riji.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    User login(@Param("user_mail") String userMail,@Param("user_password") String userPassword);

}
