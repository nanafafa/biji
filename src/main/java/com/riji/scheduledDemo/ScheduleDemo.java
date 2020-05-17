package com.riji.scheduledDemo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author 杨鹏发
 * @date 2020/5/7 0007
 */
@Component
public class ScheduleDemo {

    /**
     * 每s执行一次
     *
     * @throws InterruptedException
     */
    ///@Scheduled(cron = "0/5 * * * * ?")
    //@DistributeTask(key = "tt")
     void scheduleAtFixRate() throws InterruptedException {
        System.out.println("Rate1: " + LocalDateTime.now() + " >>> " + Thread.currentThread().getName());
    }

    //@Scheduled(cron = "0/5 * * * * ?")
    //@DistributeTask(key = "tt")
     void scheduleAtFixRate2() throws InterruptedException {
        System.out.println("Rate2: " + LocalDateTime.now() + " >>> " + Thread.currentThread().getName());
    }
}
