package com.riji.scheduledDemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 杨鹏发
 * @date 2020/5/7 0007
 */
@Aspect
@Component
public class DemoAop {
    @Around("@annotation(DistributeTask)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String lock = method.getName();
        DistributeTask task = method.getAnnotation(DistributeTask.class);
        if (ExecutiveLock.instance.tryLock(task.key(), lock)) {
            System.out.println("Aop allow: " + lock);
            return joinPoint.proceed();
        } else {
            System.out.println("Aop ignore : " + lock);
            return null;
        }
    }
}
