package com.riji.controller.redistoken.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @author 杨鹏发
 * @date 2020/2/19 0019
 */
@Lazy
@Component
public class RedisToolUtils {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 写入缓存信息
     * @param key
     * @param value
     */
    public void setRedisContent(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 读取缓存信息
     * @param key
     * @return
     */
    public String getRedisContent(String key){
        return redisTemplate.opsForValue().get(key).toString();
    }

    /**
     * 更新缓存信息
     * @param key
     * @param value
     * @return
     */
    public Boolean updateRedisContent(String key,String value){
        try{
             redisTemplate.opsForValue().getAndSet(key,value);
             return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除缓存信息
     * @param key
     * @return
     */

    public Boolean deleteRedisContent(String key){
        try {
            redisTemplate.delete(key);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 设置缓存失效时间
     * @param key
     * @param expireTime
     * @return
     */
    public Boolean setRedisExpire(String key,Long expireTime){
        try {
            if(expireTime>0){
                redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);

            }
            return true;
        }catch (Exception e){

        }
        return false;
    }

    /**
     * 获取缓存失效时间
     * @param key
     * @return
     */
    public Long getRedisExpire(String key){
        return redisTemplate.getExpire(key);
    }

    /**
     * 查询key是否存在
     * @param key
     * @return
     */
    public Boolean isRedisExist(String key){
        try{
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    /**
     * @description 写入缓存信息（包含失效时间）
     * @param key
     * @param value
     * @param expireTime
     * @return
     * @author zqk
     * @since 2019/11/6
     */
    public void setRedisContent(String key,String value,Long expireTime){
        redisTemplate.opsForValue().set(key,value,expireTime, TimeUnit.SECONDS);
    }

    /**
     * @description 写入缓存信息
     * @param key
     * @param object
     * @param expireTime
     * @param timeUnit
     * @return
     * @author zqk
     * @since 2019/12/4
     */
    public void setRedisContent(String key,Object object,long expireTime,TimeUnit timeUnit){
        Assert.notNull(timeUnit, "Timeout must not be null!");
        redisTemplate.opsForValue().set(key,object,expireTime,timeUnit);
    }
}
