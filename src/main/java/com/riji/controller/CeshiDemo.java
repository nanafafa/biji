package com.riji.controller;

import com.riji.pojo.CeshiUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CeshiDemo {
    @Value("${openApi.param.name:222}")
    private String name;

    @RequestMapping("/aaa")
    public CeshiUser show(CeshiUser ceshiUser){
        System.out.println(name);
       /* System.out.println("aaaaaa");
        ceshiUser.getAge();
        ceshiUser.getName();
        System.out.println("bbbbbbbb");
        System.out.println("cccccccccc");
        return ceshiUser;*/
        ceshiUser.setName(name);
        return ceshiUser;
    }

}
