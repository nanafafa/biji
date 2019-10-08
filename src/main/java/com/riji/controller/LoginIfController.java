package com.riji.controller;

import com.riji.pojo.User;
import com.riji.util.TokenUtilsDemo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户是否登录接口
 */
@RestController
public class LoginIfController {

    @RequestMapping(value="/judgeLogin")
    public Map<String,Object> judgeLogin(String token, HttpSession session){
        Map<String,Object> map = new HashMap<>();
        if(TokenUtilsDemo.verify(token)){
            User user = (User) session.getAttribute("USER_INFO");
            map.put("code",200);
            map.put("user",user);
            map.put("true","用户登录成功");
            return map;
        }else{
            map.put("code",500);
            map.put("false","未登录或以过期");
            return map;
        }


    }

}
