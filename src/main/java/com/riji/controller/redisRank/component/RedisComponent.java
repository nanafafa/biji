package com.riji.controller.redisRank.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author 杨鹏发
 * @date 2019/10/23 0023
 */
@Component
public class RedisComponent {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加一个元素，zset与set的最大区别就是每个元素都有一个score，因此有个排序的辅助功能zadd
     * @param key
     * @param value
     * @param score
     */
    public void add(String key,String value,Float score){
        redisTemplate.opsForZSet().add(key,value,score);
    }

    /**
     * 删除元素
     * @param key
     * @param value
     */
    public void remove(String key,String value){
        redisTemplate.opsForZSet().remove(key,value);
    }

    /**
     * 增加或者减少分数
     * @param key
     * @param value
     * @param score
     */
    public Double incrScore(String key,String value,Double score){
         return redisTemplate.opsForZSet().incrementScore(key, value, score);
    }

    /**
     * 查询value对应的score
     * @param key
     * @param value
     * @return
     */
    public Double score(String key,String value){

        return redisTemplate.opsForZSet().score(key,value);
    }

    /**
     * 判断value在zset的排名
     * 积分小的在前面
     * @param key
     * @param value
     * @return
     */
    public Long rank(String key,String value){
        return redisTemplate.opsForZSet().rank(key,value);
    }

    /**
     * 查询集合中指定顺序的值 0 -1是查询所有的值
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> range(String key,Long start,Long end){

        return redisTemplate.opsForZSet().range(key,start,end);
    }

    /**
     * 查询zset中指定顺序的值和score,
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> rangeWithScore(String key,Long start,Long end){
        return redisTemplate.opsForZSet().rangeWithScores(key,start,end);
    }
    /**
     * 查询集合中指定顺序的值  zrevrange
     *
     * 返回有序的集合中，score大的在前面
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> revRange(String key,Long start,Long end){
        return redisTemplate.opsForZSet().reverseRange(key,start,end);
    }

    /**
     * 获取指定集合中分数范围的值
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<String> sortRange(String key, long min, long max){
        return redisTemplate.opsForZSet().rangeByScore(key,min,max);
    }

    public Long size(String key){
        return redisTemplate.opsForZSet().zCard(key);
    }


}
