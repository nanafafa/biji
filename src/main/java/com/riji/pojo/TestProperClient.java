package com.riji.pojo;

import com.alibaba.fastjson.JSONObject;
import org.redisson.misc.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 杨鹏发
 * @date 2021/1/18 0018
 */
@RestController
public class TestProperClient {
    @Autowired
    private TestProper testProper;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @RequestMapping("/bbbbb")
    public Map<String,Object> show(){
        Map<String, Object> maps = testProper.getMaps();

       // Set<Map.Entry<String, Object>> entrySet = maps.entrySet();
        String goodscode = maps.get("goodscode").toString();
        Map<String,Object> map1 = JSONObject.parseObject(goodscode, Map.class);
        Set<Map.Entry<String, Object>> entries = map1.entrySet();
        for(Map.Entry<String, Object> map:entries){
            String key = map.getKey();
            String value = map.getValue().toString();
            redisTemplate.opsForHash().put("goodsKey",key,value);
        }
        System.out.println(redisTemplate.opsForHash().get("goodsKey",111));



        return maps;
    }

}
