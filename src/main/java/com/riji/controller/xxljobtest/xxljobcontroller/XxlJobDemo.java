package com.riji.controller.xxljobtest.xxljobcontroller;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @author 杨鹏发
 * @date 2020/9/12 0012
 */
@Component
public class XxlJobDemo extends IJobHandler {
    @XxlJob(value = "testSpringbootXxl")
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        System.out.println("springboot继承xxl-job");
        return ReturnT.SUCCESS;
    }
}
