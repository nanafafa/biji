package com.riji.controller.mideng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 杨鹏发
 * @date 2021/1/5 0005
 */
@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;
    @GetMapping
    public Response token(){
        return tokenService.createToken();
    }

    @PostMapping("checktoken")
    public Response checktoken(HttpServletRequest request){
        return tokenService.checkToken(request);
    }
}
