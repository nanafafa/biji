package com.riji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author 杨鹏发
 * @date 2019/10/24 0024
 */
@RestController
public class redisController {

//    @Autowired
//    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/ceshiredis")
    public String addDemo(){
        String key="ceshide";
        int value=1;
        Double score=75.0;
        Boolean flag = redisTemplate.opsForZSet().add(key, value, score);
        if(flag){
            return "成功";
        }
        return "失败";
    }
    @GetMapping("/getAll")
    public Set<Object> getAll1(){
        String key="ceshide";
        int value=1;
        //Double score = redisTemplate.opsForZSet().score(key, value);
        Set<Object> range = redisTemplate.opsForZSet().range(key, 0, -1);
        return range;
    }

}
