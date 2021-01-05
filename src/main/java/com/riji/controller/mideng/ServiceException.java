package com.riji.controller.mideng;

/**
 * @author 杨鹏发
 * @date 2021/1/5 0005
 */

//自定义异常以及配置全局异常类
public class ServiceException extends RuntimeException{
    private String code;
    private String msg;


    public ServiceException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
