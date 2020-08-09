package com.riji.xianliu.aspect;

import com.google.common.collect.Lists;
import com.riji.xianliu.annotation.DlRateLimiter;
import com.riji.xianliu.annotation.DlRedisLimiter;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 杨鹏发
 * @date 2020/8/9 0009
 */
@Aspect
@Component
public class RedisLimiterAspect {
    @Autowired
    private HttpServletResponse response;
    /**
     * 操作redis的模板
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //执行redis脚本的类
    private DefaultRedisScript<List> redisScript;

    @PostConstruct
    public void init(){
        redisScript= new DefaultRedisScript<List>();
        redisScript.setResultType(List.class);
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("limit.lua")));
    }
    @Pointcut("execution(public * com.riji.xianliu.controller.*.*(..))")//这个包下的类的任意类的任意方法
    public void pointcut(){
    }

    @Around("pointcut()")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //方法签名
        MethodSignature signature =(MethodSignature) proceedingJoinPoint.getSignature();
        //使用java反射技术获取方法上是否有@DlRateLimiter 注解类
        DlRedisLimiter dlRedisLimiter = signature.getMethod().getDeclaredAnnotation(DlRedisLimiter.class);
        if(null==dlRedisLimiter){
            //正常执行方法  执行目标业务方法即可
            return proceedingJoinPoint.proceed();
        }
        //获取注解上的参数,获取配置的速率
        double value = dlRedisLimiter.value();
        //list设置lua的KEYS[1]
        //取当前时间戳到单位秒
        String key = "ip:" + System.currentTimeMillis() / 1000;
        List<String> keyList = Lists.newArrayList(key);
        //用map设置lua的ARGV[1]
       // List<String> argvList = Lists.newArrayList(String.valueOf(value));
        //调用脚本并执行
        List result = stringRedisTemplate.execute(redisScript, keyList, String.valueOf(value));
        System.out.println("lua脚本执行结果："+result);
        //lua脚本返回0表示超出流量大小，返回1表示没有超出流量大小
        if(StringUtils.equals(result.get(0).toString(),"0")){
            fullBack();
            return null;
        }
        //没有限流，直接执行   就是controller的正常的逻辑
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
