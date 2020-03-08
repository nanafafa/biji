package com.riji.controller.tokenDemo;

import io.jsonwebtoken.*;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @author 杨鹏发
 * @date 2020/3/2 0002
 */
public class JwtTokenUtil {
    private static Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);
    public static final String AUTH_HEADER_KEY = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 解析jwt
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (ExpiredJwtException eje) {
            log.error("===== Token过期 =====", eje);
            throw new CustomException(ResultCode.PERMISSION_TOKEN_EXPIRED);

        } catch (Exception e){
            log.error("===== token解析异常 =====", e);
            throw new CustomException(ResultCode.PERMISSION_TOKEN_INVALID);
        }

    }
    /**
     * 构建jwt
     * @param userId
     * @param username
     * @param role
     * @param audience
     * @return
     */
    public static String createJWT(String userId, String username, String role, Audience audience) {
        // 使用HS256加密算法
        SignatureAlgorithm signatureAlgorithm  = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //生成签名秘钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(audience.getBase64Secret());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        //userId是重要信息，进行加密下
        String encryId = Base64.encodeBase64String(userId.getBytes());
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                // 可以将基本不重要的对象信息放到claims
                .claim("role", role)
                .claim("userId", userId)
                .setSubject(username)           // 代表这个JWT的主体，即它的所有人
                .setIssuer(audience.getClientId())              // 代表这个JWT的签发主体；
                .setIssuedAt(new Date())        // 是一个时间戳，代表这个JWT的签发时间；
                .setAudience(audience.getName())          // 代表这个JWT的接收对象；
                .signWith(signatureAlgorithm, signingKey);
        //添加token的过期时间   配置文件中有时间
        int TTLMillis  = audience.getExpiresSecond();
        if(TTLMillis>=0){
            long expMillis = TTLMillis + nowMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp)  // 是一个时间戳，代表这个JWT的过期时间；
                    .setNotBefore(now); // 是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的
        }
        //生成JWT
        return builder.compact();

    }
    /**
     * 从token中获取用户名
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUsername(String token,String base64Security){

        return parseJWT(token, base64Security).getSubject();
    }
    /**
     * 从token中获取用户ID
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUserId(String token, String base64Security){
        String userId = parseJWT(token, base64Security).get("userId", String.class);
        return new String(Base64.decodeBase64(userId));
    }
    /**
     * 是否已过期
     * @param token
     * @param base64Security
     * @return
     */
    public static boolean isExpiration(String token, String base64Security) {
        return parseJWT(token, base64Security).getExpiration().before(new Date());
    }



}
