package com.riji.MyConfig;

import com.riji.controller.ceshiSpringBoot.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 杨鹏发
 * @date 2020/5/4 0004
 * @Configuration:指明当前类是一个配置类，就是替代之前的spring的配置文件
 */
@Configuration
public class MyAppConfig {
    /**
     * 在配置文件中用<bean><bean/>标签添加组件，但是现在又注解
     * @Bean:就是将方法的返回值添加到容器中,容器中的这个组件默认的id就是方法名
     */
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean给容器中添加组件了。。。");
        return new HelloService();
    }

}
