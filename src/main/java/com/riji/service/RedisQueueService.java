package com.riji.service;

import java.util.List;

public interface RedisQueueService {
    //redis的list模拟队列
    //1.存队列  将黄立戈在公司的流程存进队列
    public void listQueueInit(String identity);
    //2.触发队列   ---开始黄立戈一天的行程
    public void queueTouch(String identity);
    //3.查看黄立戈完成的队列
    public List<String> finishQueue(String identity);
    //4.查看还有多少没完成
    public List<String> queueWait(String identity);

}
