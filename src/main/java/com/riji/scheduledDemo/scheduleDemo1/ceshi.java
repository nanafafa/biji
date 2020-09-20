package com.riji.scheduledDemo.scheduleDemo1;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author 杨鹏发
 * @date 2020/8/16 0016
 */
@RestController
@Component
public class ceshi {
    @Scheduled(cron = "0/5 * * * * ?")
    @RequestMapping("secheduDemo")
    public String show(){
        System.out.println(new Date().toString());
        System.out.println("1111");

        return "fafa";
    }
}
