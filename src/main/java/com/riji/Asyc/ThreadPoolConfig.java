package com.riji.Asyc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 杨鹏发
 * @date 2020/5/8 0008
 */
@Configuration
public class ThreadPoolConfig {
    @Bean(name="execut")
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }

}
