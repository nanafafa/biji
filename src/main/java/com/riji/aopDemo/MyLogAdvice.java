package com.riji.aopDemo;

/**
 * @author 杨鹏发
 * @date 2020/5/22 0022
 */


import com.alibaba.fastjson.JSON;
//import org.apache.log4j.Logger;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 切面类
 */
@Slf4j
@Aspect
@Component
public class MyLogAdvice {

    //private  Logger logger = Logger.getLogger(MyLogAdvice.class);
    Logger logger = LoggerFactory.getLogger(getClass());
    @Pointcut("@annotation(com.riji.aopDemo.MyLog)")//切入点是谁使用了这个注解的
    public void myPointCut(){

    }
    //后置通知
    @AfterReturning(pointcut = "myPointCut()")
    public void myAfterReturn(JoinPoint joinPoint){
        //首先  可以通过参数，通过反射的方式拿到方法的名称
        //Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();
        //通过methodSignature拿到method
        Method method = methodSignature.getMethod();
        //拿到方法了就可以拿到使用了MyLog的注解
        MyLog annotation = method.getAnnotation(MyLog.class);
        String operation=null;//operation用户操作日志
        if(null!=annotation){
            operation=annotation.value();
        }
        //操作的参数
        Object[] args = joinPoint.getArgs();
        String toJSONString = JSON.toJSONString(args);
        //还可以拿到类名加上方法名
        //String methodName = joinPoint.getTarget().getClass().getName() + "." + method.getName();
        logger.debug(new Date()+"|" +operation+"|"+toJSONString);
        logger.info("adadadada");

    }


}
