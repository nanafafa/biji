package com.riji.service.impl;
import com.riji.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;


/**
 * @author 杨鹏发
 * @date 2019/10/29 0029
 */

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.fromAddr}")
    private String from;
    @Value("${spring.mail.nickName}")
    private String nickName;

    @Override
    public String sendSimpleEmail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
        simpleMailMessage.setFrom(nickName + "<" + from + ">");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        try{
            javaMailSender.send(simpleMailMessage);
            return "发送成功";

        } catch(Exception e) {
            return "发送失败";

        }


    }
}

