package com.riji.service;

/**
 * @author 杨鹏发
 * @date 2019/11/1 0001
 */
public interface MailService {
    public String sendSimpleEmail(String to, String subject, String content);
}
