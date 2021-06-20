package com.riji.controller;

import com.riji.dto.UserData;
import com.riji.pojo.User;
import com.riji.service.UserService;
import com.riji.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/login",method =GET)
    public Map<String,Object> login(/*@RequestBody*/ UserData userData){
        Map<String, Object> map = new HashMap<>();
        String userMail = userData.getUserMail();
        String userPassword = userData.getUserPassword();

        User user = userService.login(userMail,userPassword);
        if (null==user){
            map= ResultUtils.controllerResult("false", "用户名或者密码错误", null);
        }else {
            map=ResultUtils.controllerResult("true","恭喜您，登录成功",user);
        }
        return map;
    }

}
