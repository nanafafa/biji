package com.riji.ceLueMoShi;

import java.lang.annotation.*;

/**
 * @author 杨鹏发
 * @date 2020/7/4 0004
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {

    String value();
}
