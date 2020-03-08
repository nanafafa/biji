package com.riji.controller.tokenDemo;

import java.lang.annotation.*;

/**
 * @author 杨鹏发
 * @date 2020/3/3 0003
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtIgnore {
}
