package com.riji.fafaya.riji;

import com.riji.controller.ceshiSpringBoot.HelloService;
import com.riji.controller.ceshiSpringBoot.configuraPropertoryDemo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 杨鹏发
 * @date 2020/5/4 0004
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfiguareProperTest {

    @Autowired
    Person person;
    @Autowired
    private ApplicationContext ioc;

    @Test
    public void show(){
        System.out.println(person);
    }
    @Test
    public void show1(){
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

}
