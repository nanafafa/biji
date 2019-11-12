package com.riji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
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
/**
 * 配置全局的RedisTemplate
 * RedisConnectionFactory redis连接工厂
 */
//    @Bean
//    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        //使用jackson2JsonRedisSerialize替换默认序列化
//        //设置value的序列化规则和key的序列化规则
//        redisTemplate.setValueSerializer(erializerUtils.S);
//
//    }
