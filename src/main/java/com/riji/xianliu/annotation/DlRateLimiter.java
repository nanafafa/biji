package com.riji.xianliu.annotation;

import java.lang.annotation.*;

/**
 * @author 杨鹏发
 * @date 2020/8/3 0003
 */
@Target(value= ElementType.METHOD) //范围在方法上
@Retention(RetentionPolicy.RUNTIME)//在运行时执行  也就是在运行时生效
@Documented
public @interface DlRateLimiter {
    //速率   向令牌桶放数据的速率
    double rate();
    //获取令牌的超时时间
    long timeOut() default 0;

}
