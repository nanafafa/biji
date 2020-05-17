package com.riji.scheduledDemo;

import java.lang.annotation.*;

/**
 * @author 杨鹏发
 * @date 2020/5/7 0007
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DistributeTask {
    String key();
}
