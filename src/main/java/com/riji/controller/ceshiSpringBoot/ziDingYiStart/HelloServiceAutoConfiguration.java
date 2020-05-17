package com.riji.controller.ceshiSpringBoot.ziDingYiStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 杨鹏发
 * @date 2020/5/17 0017
 */
@Configuration
@ConditionalOnWebApplication  //只有是web应用，这个配置才生效
@EnableConfigurationProperties(HelloProPerties.class)      //让属性文件生效
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloProPerties helloProPerties;

    @Bean
    public HelloService helloService(){
        HelloService service = new HelloService();
        service.setHelloProPerties(helloProPerties);
        return service;
    }





}
