package com.riji.controller.redistoken.utils;

import org.springframework.stereotype.Service;

/**
 * @author 杨鹏发
 * @date 2020/2/19 0019
 */
@Service
public class BearerToken {
/**
 * @description 获取Bearer后面的加密数据
 * @param token
 * @return
 * @author zqk
 * @since 2019/12/4
 */

public String getBearerToken(String token) throws Exception {
    if(!token.startsWith("Bearer")){
        throw new Exception("无效token");
    }
    return token.replace("Bearer","").trim();
}


}
