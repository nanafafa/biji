package com.riji.controller.redistoken.com.july;

/**
 * @author 杨鹏发
 * @date 2020/2/19 0019
 *
 *
 */

import com.alibaba.fastjson.JSON;
import com.riji.controller.redistoken.utils.BearerToken;
import com.riji.controller.redistoken.utils.OwnException;
import com.riji.controller.redistoken.utils.RedisToolUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录用户拦截器
 * @author zqk
 * @since 2019/12/4
 */
@Component
@Slf4j
public class LoginIntercept implements HandlerInterceptor {
//    private final String authorization = "Authorization";
//    @Resource
//    private BearerToken bearerToken;
//    @Resource
//    private RedisToolUtils redisToolUtils;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader(authorization);
//        if(StringUtils.isEmpty(token)){
//            throw new OwnException("登录信息无效");
//        }
//        String loginKey = bearerToken.getBearerToken(token);
//        Object userObj = redisToolUtils.getRedisContent(SysConfig.LoginInfo.CACHE_NAME + loginKey);
//        if(userObj == null){
//            throw new OwnException("用户未登录");
//        }
//        String userId = String.valueOf(userObj);
//        Object userJsonObj = redisToolUtils.getRedisContent(SysConfig.LoginInfo.CACHE_NAME + userId);
//        String userJson = String.valueOf(userJsonObj);
//        log.info("输出信息{}",userJson);
//        UserLoginDto userInfo = JSON.parseObject(userJson, UserLoginDto.class);
//        if(!loginKey.equals(userInfo.getToken())){
//            throw new OwnException("登录信息已过期");
//        }
//        return true;
//    }

}
