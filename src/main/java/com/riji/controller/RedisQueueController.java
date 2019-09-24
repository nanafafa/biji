package com.riji.controller;

import com.riji.service.RedisQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/queue")
public class RedisQueueController {
    /**
     * redis任务队列
     * 2019年8月31日23:32:18
     */
    @Autowired
    private RedisQueueService redisQueueService;
    String identity="xiaohuang";
    @RequestMapping("/huang")
    public List<String> testRedisQueue(){
        //1.生成队列
        redisQueueService.listQueueInit(identity);

        //2.当前待执行的任务队列
        System.out.println("当前待执行的任务队列");
        List<String> list = redisQueueService.queueWait(identity);
        for(String s:list){
            System.out.println(s);
        }
        //小黄开始依次执行一天的任务
        redisQueueService.queueTouch(identity);
        //再次查询等待完成的任务
        System.out.println("再次查询等待完成的任务");
        List<String> list1 = redisQueueService.queueWait(identity);
        for(String s1:list1){
            System.out.println(s1);
        }
        //查询已完成的队列
        System.out.println("已完成的队列");
        List<String> list2 = redisQueueService.finishQueue(identity);
        for(String s2:list2){
            System.out.println(s2);
        }
        return list2;
    }
}
