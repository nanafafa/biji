package com.riji.Asyc.yibu.ceshiYiBu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 杨鹏发
 * @date 2020/6/26 0026
 */
public class RunnableTask1 implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(){

        synchronized (this){
            try {
                for (int i = 1;i <= 100;i++){
                    System.out.println(Thread.currentThread().getName()+"----------异步：>"+i);
                    Thread.sleep(500);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
