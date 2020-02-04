package com.riji.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2019/12/30 0030
 */
@RestController
public class JSONDemo {

    @RequestMapping(value = "/ceshi",method = RequestMethod.POST)
    public String ceshi(@RequestBody String data1){
         //JSONObject jsonObject1 = JSON.parseObject("data1"); 报错

        JSONObject jsonObject =(JSONObject) JSONObject.parse(data1);

        String name = jsonObject.getString("name");
        String age = jsonObject.getString("age");
//         String name = jsonObject.getString("name");
//        JSONObject  jsonObject =(JSONObject) JSON.parse(data1);
        //将json映射成对象，两种
        //JSONShi jsonShi = JSON.parseObject(data1, JSONShi.class);
        //JSONShi jsonShi =JSONObject.parseObject(data1, JSONShi.class);
        return name;
    }

}
