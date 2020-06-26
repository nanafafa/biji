package com.riji.Asyc.yibu;

/**
 * @author 杨鹏发
 * @date 2020/6/26 0026
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CeshiTest {
    @Autowired
    private SendMail sendMail;
    @RequestMapping("/ceshiYiBu")
    public String show(){
        //Long result = sendMail.send();
        //System.out.println(result);
        new Thread(()->{
            for (int i = 0; i <2000000 ; i++) {
                System.out.println(i);
            }
        }).start();

        return "发送完成";
    }

}
