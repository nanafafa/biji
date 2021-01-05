package com.riji.controller.mideng;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 杨鹏发
 * @date 2021/1/5 0005
 */
@ControllerAdvice
public class MyControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public Response serviceExceptionHandler(ServiceException exception){
        Response response = new Response(Integer.valueOf(exception.getCode()), exception.getMsg(), null);
        return response;
    }
}
