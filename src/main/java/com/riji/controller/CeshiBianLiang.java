package com.riji.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 杨鹏发
 * @date 2020/9/6 0006
 */
@RestController
public class CeshiBianLiang {

   // private Integer a=10;
    //ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
    @RequestMapping("/testBianLiang")
   /* public Integer show(Integer Type){
        int a=20;
        if(Type==1){
            a=30;
        }else {
            a+=20;
        }
        return a;
    }*/
   public Date show(@RequestBody TestDate testDate){
        String startDate = testDate.getStartDate();
        String name = testDate.getName();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=null;
        try {
            date=dateFormat.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
