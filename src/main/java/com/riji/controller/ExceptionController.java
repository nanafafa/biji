package com.riji.controller;

import com.riji.dto.UserVO;
import com.riji.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ExceptionController {
    @RequestMapping("/ceshiException")
    public Map<String, Object> show(){
        Map<String, Object> map = new HashMap<>();
        int a=10;
        int b=20;
        if (a>b){
            throw new ExceptionUtils("返回给前端异常信息啦");
        }else{
            UserVO userVO = new UserVO();
            userVO.setName("发发");
            userVO.setAge("18");
            map.put("student",userVO);
            return map;
        }
    }
}
