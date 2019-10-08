package com.riji.controller;

import com.riji.pojo.User;
import com.riji.service.UserService;
import com.riji.util.TokenUtilsDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录接口
 */
@RestController
public class GetUserInfoToken {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login")
    public Map<String,Object> getUserInfo(HttpSession session,String userMail,String password){
        Map<String, Object> map = new HashMap<>();

        //使用token工具类生成token串
        String token = TokenUtilsDemo.tokenTest(userMail, password);
        //根据用户名及密码查找用户
        User user = userService.login(userMail, password);
        if(user!=null){
            //将用户对象放到session中
            session.setAttribute("USER_INFO",user);
            //用户无操作30分钟，需重新登录
            session.setMaxInactiveInterval(60*30);
            map.put("true","登录成功");
            map.put("USER_INFO",user);
            map.put("SESSIONID",session.getId());
            map.put("token",token);

            return map;
        }else {
            map.put("false","登录失败");
            return map;
        }

    }

}
