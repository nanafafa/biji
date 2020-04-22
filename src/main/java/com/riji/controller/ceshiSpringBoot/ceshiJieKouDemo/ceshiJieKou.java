package com.riji.controller.ceshiSpringBoot.ceshiJieKouDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2020/4/22 0022
 */
@RestController
public class ceshiJieKou {
//    @Autowired
//    private ZiJieKou ziJieKou;

    @Autowired
    private ZiJieKou ziJieKou;
//    @Autowired
//    private BJiCheng bJiCheng;

    @RequestMapping("/ceshiJieKou1")
    public String show(){
        return new BJiCheng().show();
        //return bJiCheng.show();
//        String result=ziJieKou.getName("sss");
//        return result;
    }

}
