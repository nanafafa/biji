package com.riji.controller.redistoken.utils;

import java.util.UUID;

/**
 * @author 杨鹏发
 * @date 2020/2/19 0019
 */
public class UuidUtil {
    /**
     * description: 获取UUid前13位
     * @return
     * @author zqk
     * @since 2019/12/4
     */
    public static String getUuid(){
        return UUID.randomUUID().toString().toUpperCase().substring(0,12);
    }

    public static String getReplaceUuid() {
        return UUID.randomUUID().toString().toUpperCase().replace("-","");
    }

    public static String getSaltUuid() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
