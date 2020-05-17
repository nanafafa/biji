package com.riji.controller.ceshiSpringBoot.ziDingYiStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2020/5/17 0017
 */
@RestController
public class TestZiDingYiStarterController {

    @Autowired
    private HelloService helloService;
    @RequestMapping("/ceshizidingyi")
    public HelloService show1(){
        return helloService;
    }


}
