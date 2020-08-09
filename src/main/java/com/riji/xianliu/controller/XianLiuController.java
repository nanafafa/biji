package com.riji.xianliu.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.riji.xianliu.annotation.DlRateLimiter;
import com.riji.xianliu.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 杨鹏发
 * @date 2020/8/3 0003
 */
@RestController
public class XianLiuController {

    @Autowired
    private OrderService orderService;

   private static final Logger logger= LoggerFactory.getLogger(XianLiuController.class);

    /**
     * create方法传入一个参数表示以固定的速率5r/s，每秒5个令牌的速率向桶中存入令牌
     * 相当于该接口每秒钟的时间   只能支持5个客户端访问
      */
    //这是一个独立线程
   RateLimiter rateLimiter= RateLimiter.create(2);

   @RequestMapping("/boot/order")
   public String order(){
       String result="";
       //1.限流处理，客户端请求从桶中获取令牌，如果在500毫秒内没有获取到令牌的话，则直接走服务降级处理
       boolean tryAcquire = rateLimiter.tryAcquire(500, TimeUnit.MILLISECONDS);
       if(!tryAcquire){
            result="哎呀，服务器太挤了,没有办法挤进去";
            logger.info(result);
           return result;
       }
        //2.业务逻辑处理
       int addRows = orderService.addOrder();
       if(addRows>0){
            result="恭喜您，秒杀下单成功";
            return result;
       }
       result ="Sorry,秒杀下单失败了，请再试一次吧";
       return result;
   }

    /**
     * 基于注解方式实现服务限流
     */
    //1秒钟向令牌桶中放1个，超时时间是500ms
    @DlRateLimiter(rate=1.0,timeOut = 500)
    @RequestMapping("/boot/order2")
    public String order2(){
        String result="";
        //2.业务逻辑处理
        int addRows = orderService.addOrder();
        if(addRows>0){
            result="恭喜您，秒杀下单成功";
            return result;
        }
        result ="Sorry,秒杀下单失败了，请再试一次吧";
        return result;
    }

}
