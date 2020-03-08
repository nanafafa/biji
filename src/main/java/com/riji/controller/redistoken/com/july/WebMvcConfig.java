package com.riji.controller.redistoken.com.july;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author 杨鹏发
 * @date 2020/2/19 0019
 *
 * 接口控制类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private LoginIntercept loginIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercept).addPathPatterns("/**")
                .excludePathPatterns("/userinfo/login", "/userinfo/generatorImgCode", "/userinfo/saveUser");
    }
}