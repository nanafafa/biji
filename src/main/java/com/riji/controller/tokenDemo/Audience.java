package com.riji.controller.tokenDemo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 杨鹏发
 * @date 2020/3/2 0002
 */
@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {
    //代表这个JWT的接收对象,存入audience
    private String clientId;
    //# 密钥, 经过Base64加密, 可自行替换
    private String base64Secret;
    // # JWT的签发主体，存入issuer
    private String name;
    // # 过期时间，时间戳
    private int expiresSecond;
}
