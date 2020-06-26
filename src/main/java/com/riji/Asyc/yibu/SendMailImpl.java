package com.riji.Asyc.yibu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @author 杨鹏发
 * @date 2020/6/26 0026
 */
@Service
public class SendMailImpl implements SendMail{
    @Async
    @Override
    public Long send() {
        long n = Instant.now().toEpochMilli();
        for (int i = 0; i <200 ; i++) {
            System.out.println(i);
        }
        long f = Instant.now().toEpochMilli();
        return f-n;
    }
}
