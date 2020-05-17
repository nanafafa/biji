package com.riji.controller;

import com.alibaba.fastjson.JSON;
import com.riji.dianzan.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨鹏发
 * @date 2020/5/10 0010
 */
@RestController
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("reqa")
    public String show(){
//        UserDemo1 user1 = new UserDemo1("fafa", 17);
//        UserDemo1 user2 = new UserDemo1("fafa", 17);
//        ArrayList<UserDemo1> list = new ArrayList<>();
//        list.add(user1);
//        list.add(user2);
//        redisTemplate.opsForValue().set("aa", JSON.toJSONString(list));
//        ArrayList<UserDemo1> list2 = new ArrayList<>();
//        list2 = JSON.parseArray(redisTemplate.opsForValue().get("aa").toString(),UserDemo1.class));
//        return list2;

        redisTemplate.opsForValue().set("aa","fafa");
        String aa = redisTemplate.opsForValue().get("aa").toString();
        return aa;


    }
}
