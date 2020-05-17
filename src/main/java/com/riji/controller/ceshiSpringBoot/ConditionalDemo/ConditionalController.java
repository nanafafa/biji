package com.riji.controller.ceshiSpringBoot.ConditionalDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2020/5/6 0006
 */
@RestController
public class ConditionalController {

//    @Autowired
//    private Person person1;
    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/cconditionalTest")
    public Person showe(){
        boolean flag=applicationContext.containsBean("bill");
        Person bill =(Person) applicationContext.getBean("bill");
        return bill;

    }
}
