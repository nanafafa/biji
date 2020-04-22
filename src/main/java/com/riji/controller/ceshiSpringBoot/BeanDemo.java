package com.riji.controller.ceshiSpringBoot;

import com.riji.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 杨鹏发
 * @date 2020/4/22 0022
 */
@Configuration
public class BeanDemo {
    @Bean
    public User getUser(){
        User user = new User();
        user.setId("111");
        user.setUser_password("222");
        return user;
    }

}
