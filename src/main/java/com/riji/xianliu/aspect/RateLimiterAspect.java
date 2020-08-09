package com.riji.xianliu.aspect;

import com.google.common.util.concurrent.RateLimiter;
import com.riji.xianliu.annotation.DlRateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @author 杨鹏发
 * @date 2020/8/3 0003
 */
@Aspect  //代表这个类是切面类
@Component  //加载到spring容器中
public class RateLimiterAspect {
    @Autowired
    private HttpServletResponse response;
    //创建了一个令牌桶限流算法的限流器  1s向里面放700个，为了方便测试先放2个
    RateLimiter rateLimiter=RateLimiter.create(2);
    //切入点
    @Pointcut("execution(public * com.riji.xianliu.controller.*.*(..))")//这个包下的类的任意类的任意方法
    public void pointcut(){
    }
    @Around("pointcut()")//环绕通知增强   环绕通知是有返回值的
    public Object process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //方法签名
        MethodSignature signature =(MethodSignature) proceedingJoinPoint.getSignature();
        //使用java反射技术获取方法上是否有@DlRateLimiter 注解类
        DlRateLimiter dlRateLimiter = signature.getMethod().getDeclaredAnnotation(DlRateLimiter.class);
        if(null==dlRateLimiter){
            //正常执行方法  执行目标业务方法即可
            return proceedingJoinPoint.proceed();
        }
        //获取注解上的参数,获取配置的速率
        double rate = dlRateLimiter.rate();
        //获取注解上的参数,获取等待令牌等待时间
        long timeOut = dlRateLimiter.timeOut();
        //设置限流速率
        rateLimiter.setRate(rate);
        //判断令牌桶获取token是否超时
        boolean tryAcquire = rateLimiter.tryAcquire(timeOut, TimeUnit.MILLISECONDS);
        if(!tryAcquire){
            //服务降级
            fullBack();
            return null;
        }
        //获取到令牌，直接执行   就是controller的正常的逻辑
        return proceedingJoinPoint.proceed();
    }
    /**
     * 服务降级方法
     */
    private void fullBack(){
        response.setHeader("Content-type","text/html;charset=UTF-8");
        PrintWriter writer=null;
        try{
            writer = response.getWriter();
            writer.println("哎呀，服务器开小差了，请重试一下吧");
            writer.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null!=writer){
                writer.close();
            }
        }


    }


}
