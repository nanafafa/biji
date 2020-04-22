package com.riji.controller.ceshiSpringBoot;

import com.riji.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2020/4/22 0022
 */
@RestController
public class BeanController {
    @Autowired
    private User user;
    @RequestMapping("/ceshiBean")
    public User show(){
        return user;
    }

}
