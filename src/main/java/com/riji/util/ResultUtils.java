package com.riji.util;

import java.util.HashMap;
import java.util.Map;

public class ResultUtils {
    public static Map<String,Object> controllerResult(String flag,String msg,Object data){
        Map<String, Object> map = new HashMap<>();
        map.put("flag",flag);
        map.put("msg",msg);
        if(null!=data){
            map.put("data",data);
        }
        return map;


    }
}
