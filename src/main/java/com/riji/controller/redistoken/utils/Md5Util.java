package com.riji.controller.redistoken.utils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

/**
 * @author 杨鹏发
 * @date 2020/2/19 0019
 * MD5加密
 */
public class Md5Util {
    public static String generatePassword(String passWord,String salt){
        return md5Hex(salt+passWord);
    }
    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }
}
