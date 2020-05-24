package com.riji.aopDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2020/5/22 0022
 */
@RestController
public class UserAopController {
    @MyLog("用户操作日志")//真正有效的是用了这个注解的地方
    @RequestMapping("ceshiaop")
    public UserDemo11 getUser(){
        return new UserDemo11("fafa",17);
    }
}
