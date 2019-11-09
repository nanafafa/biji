package com.riji.controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏发
 * @date 2019/11/1 0001
 */
@RestController
public class JsonArrayDemo {
    @RequestMapping("/ceshila")
    public JSONArray show(){
        JSONArray jsonArray = new JSONArray();
        /**
         * [
         * "aa",
         * "bb",
         * "cc",
         * "dd",
         * "ee",
         * "ff"
         * ]
         */
//        jsonArray.add("aa");
//        jsonArray.add("bb");
//        jsonArray.add("cc");
//        jsonArray.add("dd");
//        jsonArray.add("ee");
//        jsonArray.add("ff");

        /**
         * 第二种
         *
         * [
         * [
         * "111",
         * "22",
         * "333"
         * ],
         * [
         * "222",
         * "99",
         * "123"
         * ],
         * [
         * "333",
         * "88",
         * "4312"
         * ],
         * [
         * "444",
         * "77",
         * "343"
         * ]
         * ]
         *
         */
        jsonArray.add(0,new String[]{"111","22","333"});
        jsonArray.add(1,new String[]{"222","99","123"});
        jsonArray.add(2,new String[]{"333","88","4312"});
        jsonArray.add(3,new String[]{"444","77","343"});
        return jsonArray;
    }


}
