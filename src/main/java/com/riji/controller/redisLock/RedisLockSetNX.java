package com.riji.controller.redisLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 杨鹏发
 * @date 2019/12/20 0020
 */
@RestController
public class RedisLockSetNX {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private RedisTemplate stringRedisTemplate;

    @RequestMapping("/deduct_stock")
    public String deductStock(){
        String key="stock";
        String lockKey="lockKey";
        String clientId = UUID.randomUUID().toString();
        Boolean result=stringRedisTemplate.opsForValue().setIfAbsent(lockKey,clientId,10, TimeUnit.SECONDS);
       if(!result){
           return "系统繁忙";
       }

       try{
        //拿到缓存中库存
        Integer stock  =Integer.valueOf(stringRedisTemplate.opsForValue().get(key));
        if(stock>1){
            Integer realStock= stock-1;
            stringRedisTemplate.opsForValue().set(key,realStock+"");
            System.out.println("扣减成功，剩余库存"+realStock);
        }else{
            System.out.println("扣减失败，");

        }
        }finally {
           if(clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))){
               stringRedisTemplate.delete(lockKey);
           }

        }
        return "end";
    }
}
