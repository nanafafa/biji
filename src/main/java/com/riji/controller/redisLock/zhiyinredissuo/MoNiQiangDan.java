package com.riji.controller.redisLock.zhiyinredissuo;

import com.baomidou.mybatisplus.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author 杨鹏发
 * @date 2020/1/30 0030
 */
@RestController
public class MoNiQiangDan {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //总库存
    private long nKuCuen = 0;
    //商品Key的名字

    private String shangpingKey = "computer_key";
    //获取锁的超时时间 秒
    private int timeout=30*1000;

    @GetMapping("/qiangdan")
    public List<String> qiangdan(){
        //抢到商品的用户
        List<String> shopUsers=new ArrayList<>();
        //构造很多用户
        List<String> users = new ArrayList<>();
        IntStream.range(0, 10000).parallel().forEach(b -> {
            users.add("神牛-" + b);
        });
        //初始化库存
        nKuCuen=10;
        //模拟开抢
        users.parallelStream().forEach(b -> {
            String shopUser = qiang(b);
            if (!StringUtils.isEmpty(shopUser)) {
                shopUsers.add(shopUser);
            }
        });
        return shopUsers;
    }

    //模拟抢单动作
    private String qiang(String b){
        //用户开抢时间
        long startTime = System.currentTimeMillis();
        //未抢到的情况下，30秒内继续获取锁
        while((startTime+timeout)>=System.currentTimeMillis()) {

                //商品是否有剩余
                if (nKuCuen <= 0) {
                    break;
                }
                if(null!=b){

                    Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(shangpingKey, b);
                    if (result) {
                        //用户b拿到锁
                        System.out.println("用户{}拿到锁。。。" + b);
                        //判断商品是否有剩余
                        try {
                            if (nKuCuen <= 0) {
                                break;
                            }
                            //模拟生成订单耗时操作
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //抢购成功，商品递减，记录用户
                            nKuCuen -= 1;
                            //抢单成功跳出
                            System.out.println("用户" + b + "抢单成功跳出...所剩库存：" + nKuCuen);
                            return b + "抢单成功,所剩库存：" + nKuCuen;
                        } finally {
                            //释放锁
                            System.out.println("用户"+b+"释放了锁");
                            //jedis.del(shangpingKey,b);
                            stringRedisTemplate.delete(shangpingKey);
                        }
                    }else{

                    }
                }
            //Long setnx = jedis.setnx(shangpingKey, b);

                }
        return "";
    }



}
