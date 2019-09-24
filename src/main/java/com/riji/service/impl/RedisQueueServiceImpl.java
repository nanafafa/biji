package com.riji.service.impl;

import com.riji.service.RedisQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RedisQueueServiceImpl implements RedisQueueService {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存黄立戈一天的任务进队列
     * @param identity
     */
    @Override
    public void listQueueInit(String identity) {
        //初始化key   黄立戈一天有多少任务
        String key="huang7"+identity;
        redisTemplate.opsForList().leftPushAll(key,"起床","到公司","改bug","吃饭","继续改bug","改好bug","下班回家");
    }

    /**
     * 触发队列
     * @param identity
     */
    @Override
    public void queueTouch(String identity) {
        String key="huang7"+identity+":success";
        redisTemplate.opsForList().rightPopAndLeftPush("huang"+identity,key);
    }

    /**
     * 黄立戈已完成的队列  ----已完成的任务
     * @param identity
     * @return
     */
    @Override
    public List<String> finishQueue(String identity) {
        String key="huang7"+identity+":success";
        List<String> list=redisTemplate.opsForList().range(key,0,-1);
        return list;
    }

    /**
     * 未完成的队列  ---未完成的任务
     * @param identity
     * @return
     */
    @Override
    public List<String> queueWait(String identity) {
        String key="huang7"+identity;
        List<String> list1=redisTemplate.opsForList().range(key,0,-1);
        return list1;
    }

}
