package com.riji.Asyc;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

/**
 * @author 杨鹏发
 * @date 2020/5/8 0008
 */
@RestController
public class EmailController {

    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private ExecutorService execut;
    @RequestMapping("/emailCon")

    public void hello(){


        //StringUtils.isNotBlank()

        System.out.println("start");
        /**
         * 日志的级别
         * 由低到高 trace<debug<info<warn<error
         * 可以调整日志的输出级别，日志就只会在这个日志的级别和高级别生效
         * springboot默认调整的是info级别
         *
         */


        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        logger.info("这是info日志{}"+"ssss");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
        execut.execute(new EmailRunnable("发发"));
        System.out.println("end");
    }
}
