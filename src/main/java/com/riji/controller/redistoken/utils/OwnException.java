package com.riji.controller.redistoken.utils;

/**
 * @author 杨鹏发
 * @date 2020/2/19 0019
 */
public class OwnException extends Exception{
    private String message;

    public OwnException(String message){
        super(message);
        this.message=message;
    }
}
