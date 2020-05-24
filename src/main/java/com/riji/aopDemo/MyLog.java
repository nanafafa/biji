package com.riji.aopDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 杨鹏发
 * @date 2020/5/22 0022
 */

/**
 * 注解
 */

@Target(ElementType.METHOD)
//能否被反射读取到
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

    String value() default "用户操作";

}
