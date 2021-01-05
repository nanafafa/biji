package com.riji.controller.mideng;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 杨鹏发
 * @date 2021/1/5 0005
 */
@Service
public interface TokenService {
    public Response createToken();
    public Response checkToken(HttpServletRequest request);
}
