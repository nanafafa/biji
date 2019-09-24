package com.riji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

//(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
@EnableScheduling
@Configuration
//配置mapper层的扫描
@MapperScan(basePackages={"com.riji.dao"})
public class FafayaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FafayaApplication.class, args);
    }

}
