package com.riji.controller.validationedDemo;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 杨鹏发
 * @date 2020/12/13 0013
 */
public class ValidatorUtils {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * bean整体校验，有不合规范，抛出第1个违规异常
     */
    public static void validate(Object obj, Class<?>... groups) {
        Set<ConstraintViolation<Object>> resultSet = validator.validate(obj, groups);
        if (resultSet.size() > 0) {
            //如果存在错误结果，则将其解析并进行拼凑后异常抛出
            List<String> errorMessageList = resultSet.stream().map(o -> o.getMessage()).collect(Collectors.toList());
            StringBuilder errorMessage = new StringBuilder();
            errorMessageList.stream().forEach(o -> errorMessage.append(o + ";"));
            throw new IllegalArgumentException(errorMessage.toString());
        }
    }

    /**
     * 使用
     */

//    public boolean orderCheck(OrderCheckBO orderCheckBO) {
//        //对参数对象进行数据校验
//        ValidatorUtils.validate(orderCheckBO);
//        return true;
//    }



}
