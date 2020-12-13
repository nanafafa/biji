//package com.riji.controller.validationedDemo;
//
//import lombok.SneakyThrows;
//import org.hibernate.annotations.Target;
//
//import javax.validation.Constraint;
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import javax.validation.Payload;
//import java.lang.annotation.Documented;
//import java.lang.annotation.Retention;
//import java.lang.reflect.Method;
//
//import static java.lang.annotation.ElementType.*;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;
//
///**
// * @author 杨鹏发
// * @date 2020/12/13 0013
// */
//
//@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
//@Retention(RUNTIME)
//@Documented
//@Constraint(validatedBy = {EnumValue.EnumValueValidator.class})
//public @interface EnumValue {
//    //默认错误消息
//    String message() default "必须为指定值";
//
//    //支持string数组验证
//    String[] strValues() default {};
//
//    //支持int数组验证
//    int[] intValues() default {};
//
//    //支持枚举列表验证
//    Class<?>[] enumValues() default {};
//
//    //分组
//    Class<?>[] groups() default {};
//
//    //负载
//    Class<? extends Payload>[] payload() default {};
//
//    //指定多个时使用
//    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
//    @Retention(RUNTIME)
//    @Documented
//    @interface List {
//        EnumValue[] value();
//    }
//
//    /**
//     * 校验类逻辑定义
//     */
//    class EnumValueValidator implements ConstraintValidator<EnumValue, Object> {
//
//        //字符串类型数组
//        private String[] strValues;
//        //int类型数组
//        private int[] intValues;
//        //枚举类
//        private Class<?>[] enumValues;
//
//        /**
//         * 初始化方法
//         *
//         * @param constraintAnnotation
//         */
//        @Override
//        public void initialize(EnumValue constraintAnnotation) {
//            strValues = constraintAnnotation.strValues();
//            intValues = constraintAnnotation.intValues();
//            enumValues = constraintAnnotation.enumValues();
//        }
//
//        /**
//         * 校验方法
//         *
//         * @param value
//         * @param context
//         * @return
//         */
//        @SneakyThrows
//        @Override
//        public boolean isValid(Object value, ConstraintValidatorContext context) {
//            //针对字符串数组的校验匹配
//            if (strValues != null && strValues.length > 0) {
//                if (value instanceof String) {
//                    for (String s : strValues) {//判断值类型是否为Integer类型
//                        if (s.equals(value)) {
//                            return true;
//                        }
//                    }
//                }
//            }
//            //针对整型数组的校验匹配
//            if (intValues != null && intValues.length > 0) {
//                if (value instanceof Integer) {//判断值类型是否为Integer类型
//                    for (Integer s : intValues) {
//                        if (s == value) {
//                            return true;
//                        }
//                    }
//                }
//            }
//            //针对枚举类型的校验匹配
//            if (enumValues != null && enumValues.length > 0) {
//                for (Class<?> cl : enumValues) {
//                    if (cl.isEnum()) {
//                        //枚举类验证
//                        Object[] objs = cl.getEnumConstants();
//                        //这里需要注意，定义枚举时，枚举值名称统一用value表示
//                        Method method = cl.getMethod("getValue");
//                        for (Object obj : objs) {
//                            Object code = method.invoke(obj, null);
//                            if (value.equals(code.toString())) {
//                                return true;
//                            }
//                        }
//                    }
//                }
//            }
//            return false;
//        }
//    }
//}
