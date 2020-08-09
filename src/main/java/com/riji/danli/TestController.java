package com.riji.danli;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2020/7/19 0019
 */
@RestController
public class TestController {

    @RequestMapping("/danliTest")
    public String show(){
        Singleton instance = Singleton.getInstance();
        instance.setAge(17);
        instance.setName("fafa");
        return "fafa";
    }
    @RequestMapping("/danliTest1")
    public String show1(){
        Singleton instance1 = Singleton.getInstance();
        instance1.getAge();
        instance1.getName();
        return "fafa1";
    }

}
