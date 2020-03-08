package com.riji.controller.tokenDemo;

/**
 * @author 杨鹏发
 * @date 2020/3/3 0003
 */

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.text.MessageFormat;

/**
 * 自定义异常类型
 * @author pyy
 **/


public class CustomException extends RuntimeException {

    //错误代码
    ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        super(resultCode.message());
        this.resultCode = resultCode;
    }

    public CustomException(ResultCode resultCode, Object... args){
        super(resultCode.message());
        String message = MessageFormat.format(resultCode.message(), args);
        resultCode.setMessage(message);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }

}
