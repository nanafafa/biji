package com.riji.controller.redisLock;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2019/12/20 0020
 */
@RestController
public class RedisLockDemo {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private RedisTemplate stringRedisTemplate;

    @RequestMapping("/deduct_stock")
    public String deductStock(){
        String key="stock";
        //stringRedisTemplate.opsForValue().set(key,"50");

        //拿到缓存中库存
        Integer stock  =Integer.valueOf(stringRedisTemplate.opsForValue().get(key));

        //int stock = Integer.valueOf(stringRedisTemplate.opsForValue().get(key).toString());
        if(stock>1){
            Integer realStock= stock-1;
            stringRedisTemplate.opsForValue().set(key,realStock+"");
            System.out.println("扣减成功，剩余库存"+realStock);
        }else{
            System.out.println("扣减失败，");

        }
        return "end";
    }
}
