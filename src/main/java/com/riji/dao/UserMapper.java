package com.riji.dao;

import com.riji.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
public interface UserMapper {
    User login(@Param("userMail") String userMail,@Param("userPassword") String userPassword);

}
