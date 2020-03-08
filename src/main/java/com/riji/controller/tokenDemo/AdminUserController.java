package com.riji.controller.tokenDemo;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author 杨鹏发
 * @date 2020/3/3 0003
 */
@Slf4j
@RestController
public class AdminUserController {
    @Autowired
    private Audience audience;
    @PostMapping("/login")
    @JwtIgnore
    public Result adminLogin(HttpServletResponse response, String username, String password) {
        // 这里模拟测试, 默认登录成功，返回用户ID和角色信息
        String userId = UUID.randomUUID().toString();
        String role = "admin";
        // 创建token
        String token = JwtTokenUtil.createJWT(userId, username, role, audience);
        log.info("### 登录成功, token={} ###", token);
        // 将token放在响应头
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
        // 将token响应给客户端
        JSONObject result = new JSONObject();
        result.put("token", token);
        return Result.SUCCESS(result);
    }
    @GetMapping("/users")
    public Result userList() {
        log.info("### 查询所有用户列表 ###");

        return Result.SUCCESS();
    }


}
