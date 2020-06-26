package com.riji.Asyc.yibu.ceshiYiBu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 杨鹏发
 * @date 2020/6/26 0026
 */
@RestController
public class Test {


    @RequestMapping(value = "test3",method = RequestMethod.GET)
    public String test3() {

         final Logger logger = LoggerFactory.getLogger(getClass());
        ExecutorService service = Executors.newFixedThreadPool(5);
//        RunnableTask1 task1 = new RunnableTask1();
//        service.execute(task1);
        String s = show2();
        service.execute(()->{
            for(int i=0;i<700000;i++){
                System.out.println(Thread.currentThread().getName()+"----------异步：>"+i);
            }
            System.out.println(s);
        });

        logger.info("=========》当前线程名：" + Thread.currentThread().getName());
        //return "异步,正在解析......";
        return s;
    }

    public String show2(){

        return "fafa";
    }

}
