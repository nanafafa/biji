package com.riji.util;

import java.io.Serializable;

/**
 * @author 杨鹏发
 * @date 2019/10/15 0015
 */
public class ResultUtilsDemo1 {
    //响应消息
    private String message;
    //响应状态
    private boolean success;
    public ResultUtilsDemo1() {
    }

    public ResultUtilsDemo1(boolean success) {
        this.success = success;
    }

    public ResultUtilsDemo1(boolean success,String message ) {
        this.message = message;
        this.success = success;
    }

//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
}
