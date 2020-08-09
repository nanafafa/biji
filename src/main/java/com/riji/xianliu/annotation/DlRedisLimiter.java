package com.riji.xianliu.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author 杨鹏发
 * @date 2020/8/3 0003
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DlRedisLimiter {
    @AliasFor("limit")//别名
    double value() default Double.MAX_VALUE;
    double limit() default Double.MAX_VALUE;


}
