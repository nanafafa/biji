package com.riji.controller.ceshiSpringBoot.ConditionalDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author 杨鹏发
 * @date 2020/5/6 0006
 */
@Configuration
public class PersonConfigure {

    @Bean(name="bill")
    @Conditional({ConditionalDemo1.class})//如果满足ConditionalDemo1，返回true,继续加载下面这个方法
    public Person person1(){
        return new Person("Bill Gates",62);
    }
}
