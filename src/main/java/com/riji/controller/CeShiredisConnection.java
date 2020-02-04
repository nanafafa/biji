package com.riji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2020/1/29 0029
 */
@RestController
public class CeShiredisConnection {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/ceshifafa")
    public String getRedis(){
        redisTemplate.opsForValue().set("name","fafa");
        String name = String.valueOf(redisTemplate.opsForValue().get("name"));
        return name;
    }

}
