//package com.riji.controller.validationedDemo;
//
///**
// * @author 杨鹏发
// * @date 2020/12/13 0013
// */
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.BindException;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * 数据合法性校验结果异常统一处理
// * 图片
// *
// * 通过前面我们所讲的各种约束注解，
// * 我们实现了对Controller层接口以及业务方法参数对象的统一数据校验。
// * 而为了保持校验异常处理的统一处理和错误报文统一输出，
// * 我们还可以定义通用的异常处理机制，
// * 来保证各类数据校验错误都能以统一错误格式反馈给调用方
// */
//@Slf4j
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    /**
//     * 统一处理参数校验错误异常(非Spring接口数据绑定验证)
//     *
//     * @param response
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(BindException.class)
//    @ResponseBody
//    public ResponseResult<?> processValidException(HttpServletResponse response, BindException e) {
//        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        //获取校验错误结果信息，并将信息组装
//        List<String> errorStringList = e.getBindingResult().getAllErrors()
//                .stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
//        String errorMessage = String.join("; ", errorStringList);
//        response.setContentType("application/json;charset=UTF-8");
//        log.error(e.toString() + "_" + e.getMessage(), e);
//        return ResponseResult.systemException(GlobalCodeEnum.GL_FAIL_9998.getCode(),
//                errorMessage);
//    }
//
//    /**
//     * 统一处理参数校验错误异常
//     *
//     * @param response
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseBody
//    public ResponseResult<?> processValidException(HttpServletResponse response, IllegalArgumentException e) {
//        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        String errorMessage = String.join("; ", e.getMessage());
//        response.setContentType("application/json;charset=UTF-8");
//        log.error(e.toString() + "_" + e.getMessage(), e);
//        return ResponseResult.systemException(GlobalCodeEnum.GL_FAIL_9998.getCode(),
//                errorMessage);
//    }
//
//    //...
//}
